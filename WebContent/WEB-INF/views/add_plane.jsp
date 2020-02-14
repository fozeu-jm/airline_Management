<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp">
	<c:param name="design" value="bleu" />
</c:import>

<c:import url="sidebar.jsp">
	<c:param name="smallactive" value="addPlane" />
	<c:param name="bigactive" value="Plane" />
</c:import>

<!-- ------------------------------------------------------END OF IMPORTS---------------------------------------------------------------------------------- -->

<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>Fill form to save plane</h2>
		</div>

		<!-- Basic Validation -->
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">
					<div class="header">
						<h2>ADD AIRPLANE</h2>
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
						<form id="form_validation" action="addAirplane" method="POST">
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control" name="planeMake"
										required> <label class="form-label">Manufacturer</label>
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="text" class="form-control" name="modelName"
										required> <label class="form-label">Model Name</label>
								</div>
							</div>
							<div class="form-group form-float">
								<div class="form-line">
									<input type="number" class="form-control" name="seatingCapacity"
										required> <label class="form-label">Seats Capacity</label>
								</div>
							</div>
							<div class="form-group">
								<div class="form-line">
									<select name="status" class="select2" required="required">
										<option value="" selected disabled>Select plane status</option>
										<option value="Operational">Operational</option>
										<option value="Maintenance">Maintenance</option>
										<option value="Broken_Down">Broken Down</option>
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
