<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="header.jsp">
	<c:param name="design" value="bleu" />
</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="editFlight" />
	<c:param name="bigactive" value="Flight" />
</c:import>

<!-- ------------------------------------------------------END OF IMPORTS---------------------------------------------------------------------------------- -->

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>Fill form to save flight</h2>
		</div>

		<!-- Basic Validation -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="header">
						<h2>EDIT FLIGHT EVENT</h2>
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
						</ul> -->
					</div>
					<div class="body">
						<form id="form_validation" action="editFlight" method="POST">
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" value="${ requestScope.flight.reference }" class="form-control"
										name="reference" required> <label
										class="form-label">Flight Reference</label>
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" value="${ requestScope.flight.flightOrigin }" class="form-control" name="flightOrigin"
										required> 
										<input type="number" value="${ requestScope.flight.id }" class="form-control" name="fid"
										readonly style="display: none;" > 
										<label class="form-label">Flight
										Origin</label>
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" value="${ requestScope.flight.flightDestination }" class="form-control"
										name="flightDestination" required> <label
										class="form-label">Flight Destination</label>
								</div>
							</div>
							<fmt:formatDate value="${requestScope.flight.depatureTime}" var="dtDate" type="date" pattern="dd-MM-yyyy/hh:mm" />
							<fmt:formatDate value="${requestScope.flight.arrivalTime}" var="atDate" type="date" pattern="dd-MM-yyyy/hh:mm" />
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" value="${ dtDate }" name="depatureTime"
										class="datetimepicker form-control" required
										placeholder="Depature Time">
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" value="${ atDate }" name="arrivalTime"
										class="datetimepicker form-control" required
										placeholder="Arrival Time">

								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" value="${ requestScope.flight.duration }" name="duration"
										class="timepicker form-control" required
										placeholder="Duration">
								</div>
							</div>
							<div class="form-group">
								<div class="form-line">
									<select name="status" class="select2" required="required">
										<option value="" selected disabled>Select flight
											status</option>
										<c:forEach items="${ requestScope.slist }" var="statut">
											<c:choose>
												<c:when test="${ statut == requestScope.flight.status }">
													<option selected value="${ requestScope.flight.status }">${ requestScope.flight.status }</option>
												</c:when>		
												<c:otherwise>
													<option value="${ statut }">${ statut }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>

								</div>
							</div>
							<div class="form-group">
								<div class="form-line">
									<select name="plane" class="select2" required="required">
										<option value="" selected disabled>Choose plane</option>
										<c:forEach items="${requestScope.planes}" var="plane">
											<c:choose>
												<c:when test="${plane.id == flight.airplane.id }">
													<option selected value="<c:out value="${plane['id']}" />">
														<c:out value="${plane['planeMake']} - ${plane['modelName']}" />
													</option>
												</c:when>
												
												<c:otherwise>
													<option value="<c:out value="${plane['id']}" />">
														<c:out value="${plane['planeMake']} - ${plane['modelName']}" />
													</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>

								</div>
							</div>
							
							<div class="form-group">
								<div class="form-line">
									<select name="pilots" multiple="multiple" class="select2">
										<option value="" disabled>Choose pilots</option>
										<c:forEach items="${requestScope.flight.pilots}" var="pilot">
											<option value="<c:out value="${pilot.id}" />" selected><c:out value="${pilot.firstName} ${pilot.lastName}" /> (${pilot.rank}) </option>	
										</c:forEach>
										
										<c:forEach items="${requestScope.allPilots}" var="pilot2">
											<option value="<c:out value="${pilot2.id}" />"><c:out value="${pilot2.firstName} ${pilot2.lastName}" /> (${pilot2.rank}) </option>
										</c:forEach>
										
									</select>

								</div>
							</div>

							<button class="btn btn-primary waves-effect" type="submit">SUBMIT</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- #END# Basic Validation -->

	</div>
</section>

<c:import url="footer.jsp">
</c:import>
