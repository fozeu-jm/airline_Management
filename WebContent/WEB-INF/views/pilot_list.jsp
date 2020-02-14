<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="header.jsp">

</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="listPilots" />
	<c:param name="bigactive" value="Pilot" />
</c:import>

<!-- ------------------------------------------------------END OF IMPORTS---------------------------------------------------------------------------------- -->

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>
				JQUERY DATATABLES
			</h2>
		</div>
		<!-- Exportable Table -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="header">
						<h2>List of Pilots</h2>
						<ul class="header-dropdown m-r--5">
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
						</ul>
					</div>
					<div class="body">
						<div class="table-responsive">
							<table
								class="table table-bordered table-striped table-hover dataTable pilot-export">
								<thead>
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Gender</th>
										<th>Pilot Licence No</th>
										<th>Pilot Rank</th>
										<th>PhoneNo</th>
										<th>Email</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Gender</th>
										<th>Pilot Licence No</th>
										<th>Pilot Rank</th>
										<th>PhoneNo</th>
										<th>Email</th>
										<th>Actions</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${requestScope.pilotlist}" var="pilot" varStatus="status">	
										<tr>
											<td><c:out value="${ status.count }"/></td>
											<td><c:out value="${fn:toUpperCase(pilot.firstName) } ${fn:toUpperCase(pilot.lastName)}" /></td>
											<td><c:out value="${ pilot.gender }" /></td>
											<td><c:out value="${ pilot.pilotLicence }"/></td>
											<td><c:out value="${ pilot.rank }" /></td>
											<td><c:out value="${ pilot.phoneNo }"/></td>
											<td><c:out value="${ pilot.email }" /></td>
											<td>
											<a href="<c:url value="/editPilot?id=${ pilot.id }"/>">Edit</a> 
											<a href="<c:url value="/deletePilot?id=${ pilot.id }"/>">Delete</a></td>
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
