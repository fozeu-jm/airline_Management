<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
	<c:param name="design" value="bleu" />
</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="addFlight" />
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
						<h2>ADD FLIGHT EVENT</h2>
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
						<form id="form_validation" action="addFlight" method="POST">
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control"
										name="reference" required> <label
										class="form-label">Flight Reference</label>
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control" name="flightOrigin"
										required> <label class="form-label">Flight
										Origin</label>
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control"
										name="flightDestination" required> <label
										class="form-label">Flight Destination</label>
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" name="depatureTime"
										class="datetimepicker form-control" required
										placeholder="Depature Time">
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" name="arrivalTime"
										class="datetimepicker form-control" required
										placeholder="Arrival Time">

								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" name="duration"
										class="timepicker form-control" required
										placeholder="Duration">
								</div>
							</div>
							<div class="form-group">
								<div class="form-line">
									<select name="status" class="select2" required="required">
										<option value="" selected disabled>Select flight
											status</option>
										<option value="ON_SCHEDULE">On Schedule</option>
										<option value="DELAYED">Delayed</option>
										<option value="ABORTED">Aborted</option>
									</select>

								</div>
							</div>
							<div class="form-group">
								<div class="form-line">
									<select name="plane" class="select2" required="required">
										<option value="" selected disabled>Choose plane</option>
										<c:forEach items="${requestScope.planes}" var="plane">

											<option value="<c:out value="${plane['id']}" />"><c:out value="${plane['planeMake']} - ${plane['modelName']}" /></option>

										</c:forEach>
									</select>

								</div>
							</div>
							
							<div class="form-group">
								<div class="form-line">
									<label style="top: -24px;" class="form-label"> Flight Pilots </label>
									<select name="pilots" multiple="multiple" class="select2">
										<option value="" disabled>Choose pilots</option>
										<c:forEach items="${requestScope.pilots}" var="pilot">

											<option value="<c:out value="${pilot.id}" />"><c:out value="${pilot.firstName} ${pilot.lastName}" /> (${pilot.rank})</option>

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
