<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="header.jsp">

</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="listFlights" />
	<c:param name="bigactive" value="Flight" />
</c:import>

<!-- ------------------------------------------------------END OF IMPORTS---------------------------------------------------------------------------------- -->

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>
				SCHEDULED FLIGHTS
			</h2>
		</div>
		<!-- Exportable Table -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="header">
						<h2>List of Flights</h2>
						<!--  <ul class="header-dropdown m-r--5">
							<li class="dropdown"><a href="javascript:void(0);"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false"> <i
									class="material-icons">more_vert</i>
							</a>
								<ul class="dropdown-menu pull-right">
									<li><a href="javascript:void(0);">Action</a></li>
									<li><a href="javascript:void(0);">Another action</a></li>
									<li><a href="javascript:void(0);">Something else here</a></li>
								</ul></li>
						</ul>-->
					</div>
					<div class="body">
						<div class="table-responsive">
							<table
								class="table table-bordered table-striped table-hover dataTable flight-export">
								<thead>
									<tr>
										<th>No</th>
										<th>Reference</th>
										<th>Origin</th>
										<th>Arrival</th>
										<th>Depature Time</th>
										<th>Arrival Time</th>
										<th>Duration</th>
										<th>Plane</th>
										<th>Status</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>No</th>
										<th>Reference</th>
										<th>Origin</th>
										<th>Arrival</th>
										<th>Depature Time</th>
										<th>Arrival Time</th>
										<th>Duration</th>
										<th>Plane</th>
										<th>Status</th>
										<th>Actions</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${requestScope.flights}" var="flight" varStatus="status">	
										<tr>
											<td><c:out value="${ status.count }"/></td>
											<td><c:out value="${ flight.reference }" /></td>
											<td><c:out value="${fn:toUpperCase(flight.flightOrigin) }" /></td>
											<td><c:out value="${fn:toUpperCase(flight.flightDestination) }" /></td>
											<fmt:formatDate value="${flight.depatureTime}" var="dtDate" type="date" pattern="dd-MM-yyyy hh:mm" />
											<fmt:formatDate value="${flight.arrivalTime}" var="atDate" type="date" pattern="dd-MM-yyyy hh:mm" />
											<td><c:out value="${ dtDate }" /></td>
											<td><c:out value="${ atDate }" /></td>
											<td><c:out value="${ flight.duration }" /></td>
											<td><c:out value="${ flight.airplane.planeMake } ${ flight.airplane.modelName }" /> (${flight.airplane.status })</td>
											<td><c:out value="${ flight.status }"/></td>
											<td>
											<a href="<c:url value="/flightPassengers?id=${ flight.id }"/>">Display Passengers</a> <br />
											<a href="<c:url value="/addTicket?id=${ flight.id }"/>">Register Ticket</a> <br />
											<a href="<c:url value="/editFlight?id=${ flight.id }"/>">Edit</a> 
											<a href="<c:url value="/deleteFlight?id=${ flight.id }"/>">Delete</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- #END# Exportable Table -->

	</div>
</section>

<c:import url="footer.jsp">
</c:import>
