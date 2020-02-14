<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="header.jsp">

</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="listPassengers" />
	<c:param name="bigactive" value="Passenger" />
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
						<h2>List of Passengers</h2>
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
								class="table table-bordered table-striped table-hover dataTable js-exportable">
								<thead>
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Gender</th>
										<th>Date of birth</th>
										<th>Passport No</th>
										<th>Email</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>No</th>
										<th>Name</th>
										<th>Gender</th>
										<th>Date of birth</th>
										<th>Passport No</th>
										<th>Email</th>
										<th>Actions</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${requestScope.plist}" var="passenger" varStatus="status">	
										<tr>
											<td><c:out value="${ status.count }"/></td>
											<td><c:out value="${fn:toUpperCase(passenger.firstName) } ${fn:toUpperCase(passenger.lastName)}" /></td>
											<td><c:out value="${ passenger.gender }" /></td>
											<fmt:formatDate value="${passenger.dob}" var="formattedDate" type="date" pattern="dd-MM-yyyy" />
											<td><c:out value="${ formattedDate }" /></td>
											<td><c:out value="${ passenger.passNo }"/></td>
											<td><c:out value="${ passenger.email }" /></td>
											<td>
											<a href="<c:url value="/editPassenger?id=${ passenger.id }"/>">Edit</a> 
											<a href="<c:url value="/deletePassenger?id=${ passenger.id }"/>">Delete</a></td>
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
