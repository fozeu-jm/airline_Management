<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="left-navbar">
	<!-- Left Sidebar -->
	<aside id="leftsidebar" class="sidebar">
		<!-- User Info -->
		<div class="user-info">
			<div class="image">
				<img src="resources/images/user.png" width="48" height="48"
					alt="User" />
			</div>
			<div class="info-container">
				<div class="name" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">User</div>
				<div class="email">john@gmail.com</div>
				<div class="btn-group user-helper-dropdown">
					<i class="material-icons" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
					<ul class="dropdown-menu pull-right">
						<li><a href="javascript:void(0);"><i
								class="material-icons">person</i>Profile</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="javascript:void(0);"><i
								class="material-icons">group</i>Followers</a></li>
						<li><a href="javascript:void(0);"><i
								class="material-icons">shopping_cart</i>Sales</a></li>
						<li><a href="javascript:void(0);"><i
								class="material-icons">favorite</i>Likes</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="javascript:void(0);"><i
								class="material-icons">input</i>Sign Out</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- #User Info -->
		<!-- Menu -->
		<div class="menu">
			<ul class="list">
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->

				<li class="header">MAIN NAVIGATION</li>
				<li class="">
					<a href="index.html"> 
						<i class="material-icons">home</i> 
						<span>Home</span>
					</a>
				</li>
				
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->
		
				<li class="${ param.bigactive == 'Passenger' ? 'active' : 'notActive' }"><a href="javascript:void(0);" class="menu-toggle"> <i
						class="material-icons">account_circle</i> <span>Passengers</span>
				</a>
					<ul class="ml-menu">
						<li class="${ param.smallactive == 'listPassengers' ? 'active' : 'notActive' }">
							<a href="<c:url value="/listpassengers" />">Passengers List</a>
						</li>
						<li class="${ param.smallactive == 'addPassenger' ? 'active' : 'notActive' }">
						<a href="<c:url value="/addPassenger" />">Add Passenger</a></li>
						
					</ul></li>
					
					
					
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->

	<li class="${ param.bigactive == 'Flight' ? 'active' : 'notActive' }"><a href="javascript:void(0);" class="menu-toggle"> <i
						class="material-icons">flight_takeoff</i> <span>Flights</span>
				</a>
					<ul class="ml-menu">
						<li class="${ param.smallactive == 'listFlights' ? 'active' : 'notActive' }">
						<a href="<c:url value="/listFlights" />">Flight List</a></li>
						
						<li class="${ param.smallactive == 'addFlight' ? 'active' : 'notActive' }">
						<a href="<c:url value="/addFlight" />">Add Flight</a></li>
						
					</ul></li>
				
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->

					<li class="${ param.bigactive == 'Plane' ? 'active' : 'notActive' }"><a href="javascript:void(0);" class="menu-toggle"> <i
						class="material-icons">airplanemode_active</i> <span>Airplane</span>
				</a>
					<ul class="ml-menu">
						<li class="${ param.smallactive == 'listPlane' ? 'active' : 'notActive' }">
						<a href="<c:url value="/listAirplane" />">Aircraft List</a></li>
						
						<li class="${ param.smallactive == 'addPlane' ? 'active' : 'notActive' }">
						<a href="<c:url value="/addAirplane" />">Add Plane</a></li>
						
					</ul></li>
				
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->

				

				<li class="${ param.bigactive == 'Pilot' ? 'active' : 'notActive' }"><a href="javascript:void(0);" class="menu-toggle"> <i
						class="material-icons">assignment_ind</i> <span>Pilots</span>
				</a>
					<ul class="ml-menu">
						<li class="${ param.smallactive == 'listPilots' ? 'active' : 'notActive' }">
						<a href="<c:url value="/pilotList" />">Pilot List</a></li>
						
						<li class="${ param.smallactive == 'addPilot' ? 'active' : 'notActive' }">
						<a href="<c:url value="/addPilot" />">Add Pilot</a></li>
						
					</ul></li>
				
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->
	

				<li class="${ param.bigactive == 'Pilot' ? 'active' : 'notActive' }"><a href="javascript:void(0);" class="menu-toggle"> <i
						class="material-icons">wc</i> <span>Stewards</span>
				</a>
					<ul class="ml-menu">
						<li class="${ param.smallactive == 'listPilots' ? 'active' : 'notActive' }">
						<a href="<c:url value="/pilotList" />">Pilot List</a></li>
						
						<li class="${ param.smallactive == 'addPilot' ? 'active' : 'notActive' }">
						<a href="<c:url value="/addPilot" />">Add Pilot</a></li>
						
					</ul></li>
				
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->
	

				<li class="${ param.bigactive == 'Pilot' ? 'active' : 'notActive' }"><a href="javascript:void(0);" class="menu-toggle"> <i
						class="material-icons">business</i> <span>Maintenance company</span>
				</a>
					<ul class="ml-menu">
						<li class="${ param.smallactive == 'listPilots' ? 'active' : 'notActive' }">
						<a href="<c:url value="/pilotList" />">Pilot List</a></li>
						
						<li class="${ param.smallactive == 'addPilot' ? 'active' : 'notActive' }">
						<a href="<c:url value="/addPilot" />">Add Pilot</a></li>
						
					</ul></li>
				
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->


				<li class="${ param.bigactive == 'Pilot' ? 'active' : 'notActive' }"><a href="javascript:void(0);" class="menu-toggle"> <i
						class="material-icons">build</i> <span>Maintenance operations</span>
				</a>
					<ul class="ml-menu">
						<li class="${ param.smallactive == 'listPilots' ? 'active' : 'notActive' }">
						<a href="<c:url value="/pilotList" />">Pilot List </a></li>
						
						<li class="${ param.smallactive == 'addPilot' ? 'active' : 'notActive' }">
						<a href="<c:url value="/addPilot" />">Add Pilot</a></li>
						
					</ul></li>
				
<!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->
				
				
			</ul>
		</div>
		<!-- #Menu -->
		<!-- Footer -->
		<div class="legal">
			<div class="copyright">
				&copy; 2019 <a href="javascript:void(0);">Cameroun airlines.</a>
			</div>
			<div class="version">
				<b>Version: </b> 1.0.5
			</div>
		</div>
		<!-- #Footer -->
	</aside>
	<!-- #END# Left Sidebar -->
</section>
