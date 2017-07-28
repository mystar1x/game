var map, markers, infoWindow, foursquareBaseURL, foursquareTokensURL;

markers = [];
foursquareBaseURL = "https://api.foursquare.com/v2/venues/";
foursquareTokensURL = "?client_id=JD4OJRFFMQE5BH0R4LHIZM20CWGDKSMXXOCEZFANAALMPTJT&client_secret=AD5DK2D0DQMMWA1XDZEJ2AQPSOXKEECNHLBOWADVYIPKBQ0A&v=20161016";

function initMap(){
	map = new google.maps.Map(document.getElementById("map"), {
		center: {lat: 45.9432, lng: 24.9668},
		zoom: 7
	});

	infoWindow = new google.maps.InfoWindow({
	    content: ''
	});

	myMVM.addMarkers();
	
}



// The MapLocation class is used to create points of interest on the map.
function MapLocation(name, lat, lng, filter, foursquareid) {
	var self = this;

	self.name = name;
	self.lat = lat;
	self.lng = lng;
	self.filter = filter;
	self.foursquareid = foursquareid;
}

// MapViewModel is the Knockout view model
function MapViewModel(){
	var self = this;

	self.locations = ko.observableArray([
		new MapLocation("Danube Delta Resort", 45.342743, 28.970683, 'danube', '51cecc8b498e60330cd69cc9'),
		new MapLocation("cluj-Napoca", 46.7712, 22.6236, 'cluj', '56583381498e0ac7f524a425'),
		new MapLocation("Mamaia", 44.2624, 28.6187, 'mamaia', '55fee37b498e273b1972f901'),
		new MapLocation("Union Square Timisoara", 45.7489, 21.2087, 'union', '4bb0a950f964a5200d533ce3'),
		new MapLocation("Casino Sinia", 45.3310, 25.5624, 'casino', '4c8bec5e5e38b1f707a12cf9'),
		new MapLocation("Brasov", 45.6580, 25.6012, 'brasov', '4f7305c9e4b0979fe7478af1')
	]);

	self.currentFilter = ko.observable();

	self.filteredLocations = ko.computed( function(){
		if (!self.currentFilter()) {
			return self.locations();
		} else {
			return ko.utils.arrayFilter(self.locations(), function(loc){
				// the input filter string
				var filter = self.currentFilter().toLowerCase();
				// the 'filter' string for location containing terms to use by filter
				var locationStr = loc.filter;
				// index value of the filter in our locationStr; -1 if not present
				var strIndex = locationStr.indexOf(filter);
				// if the filter term is present in out location filter string,
				// return true to include the location in currentFilter
				if (strIndex == -1) {
					return false;
				} else {
					return true;
				}
			});
		}
	});

	self.addMarker = function(name, locationPosition, foursquareid){
		var marker = new google.maps.Marker({
			name: name,
			position: locationPosition,
			foursquareid: foursquareid,
			map: map
		});

		marker.addListener('click', function(){
			self.showInfoWindow(name, marker);
		});
		markers.push(marker);
	};

	self.setMapOnAll = function(map){
		for (var i=0; i<markers.length; i++){
			markers[i].setMap(map);
		}
	};

	self.clearMarkers = function(){
		self.setMapOnAll(null);
	};

	self.deleteMarkers = function(){
		self.clearMarkers();
		markers = [];
	};

	self.showMarkers = function(){
		self.setMapOnAll(map);
	};

	self.addMarkers = function() {
		var locations = self.filteredLocations();
		for (var i=0; i<locations.length; i++){
			var name = locations[i].name;
			var locationPosition = {};
			var foursquareid = locations[i].foursquareid;
			locationPosition.lat = locations[i].lat;
			locationPosition.lng = locations[i].lng;
			self.addMarker(name, locationPosition, foursquareid);
		}
	};

	self.filterLocations = function(){
		self.addMarkers();
		self.deleteMarkers();
		// works without showMarkers, which sets the map, but google examples
		// seem to favor explicitly setting the map, so showMarkers included
		self.showMarkers();
	};

	self.listClick = function(e){
		var listName = e.name;
		for (var i=0; i<markers.length; i++){
			var marker = markers[i];
			var markerName = marker.name;
			if (listName == markerName){
				self.showInfoWindow(markerName, marker);

			}
		}

	};

	self.showInfoWindow = function(name, marker){
		infoWindow.close();
		// setZoom and panTo zoom in the map a little and pan to the clicked
		// location; this happens when either the marker or the list item is
		// clicked
		map.setZoom(16);
		map.panTo(marker.getPosition());
		// Immediately Invoke Function Expression (IIFE) is necessary to clear
		// animations on other markers, set by previous click events
		(function(){
			for (var i=0; i<markers.length; i++){
				var marker = markers[i];
				marker.setAnimation(null);
			}
		})();
		marker.setAnimation(google.maps.Animation.BOUNCE);
		var set='<div id="info-window"><span class="info-title">'+name+ '</span>'+ '<span class="info-address"></span>'+ '<img class="info-img">'+ '<span class="info-rating"></span>'+ '</div>';
		infoWindow.setContent(set);
		infoWindow.open(map, marker);
		var foursquareURL = foursquareBaseURL + marker.foursquareid + foursquareTokensURL;
		// TODO: save ajax request data to variable to eliminate redundant requests
		// in the same session (will be taxing on Foursquare request limit). This
		// structure is fine for demo/prototype purposes.
		$.getJSON(foursquareURL)
		
		.done(function(data){
			console.log(data.response);
			var formattedAddress = data.response.venue.location.formattedAddress;
			var rating = data.response.venue.rating;
			var locationImage = data.response.venue.bestPhoto;
			var $infoAddress = $(".info-address");
			var $infoImg = $(".info-img");
			var $infoRating = $(".info-rating");
			// setting the text of $infoAdress to "" prevents multiple appends of
			// formattedAddress from multiple fast clicks
			$infoAddress.text("");
			// the conditional using length > 2 will append an error message when the
			// address is not available
			if (formattedAddress.length > 2){
				$infoAddress.append(data.response.venue.location.formattedAddress[0]);
				$infoAddress.append("<br>Romania");
			} else {
				$infoAddress.append("No Address Available");
			}
			if (locationImage) {
				$infoImg.attr("src", locationImage.prefix + "75x75" + locationImage.suffix);
			} 
			// conditional produces error if no rating is available
			if (rating){
				rating = "Rating: " + rating + "/10";
				$infoRating.append(rating);
			} else {
				$infoRating.append("no rating available");
			}
			
		});
		
		
	};
	
	

	self.sidebarShowHide = function(){
		// sidebarShowHide moves the sidebar off screen and moves the
		// sidebar-show-hide div down to avoid covering Google maps selectors. This
		// function is triggered by clicking on the sidebar-show-hide div.
		var $sidebar = $(".sidebar");
		var $sidebarShowHide = $(".sidebar-show-hide");
		if ($sidebar.hasClass("collapse")){
			$sidebar.removeClass("collapse").css("box-shadow", "3px 3px 10px 0px rgba(0,0,0,0.5)");
			$sidebarShowHide.css({
									"top": "10px"
								});
		} else{
			$sidebar.addClass("collapse").css("box-shadow", "none");
			$sidebarShowHide.css({
									"top": "80px"
								});
		}
	};
}

myMVM = new MapViewModel();
ko.applyBindings(myMVM);



