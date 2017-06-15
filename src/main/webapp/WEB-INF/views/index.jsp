<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>


<link rel="stylesheet"
	href="static/bootstrap-3.3.6-dist/css/bootstrap.min.css"></link>
<style type="text/css">
.wrapx {
	margin: 10px auto 20px 100px;
	width: 600px;
	height: 500px;
}
</style>

<meta charset="utf-8">
<meta name="google">
</head>
<body>
	<div id="ntp-contents" class="wrapx">


		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">接口验证</h3>
			</div>

			<div class="panel-body">
				<form action="flit" method="post" id="flitForm">
					<div class="input-group" style="margin: 10px auto">
						<span class="input-group-addon" id="basic-addon1">url</span> <input
							type="text" id="inter_url" name="uri" class="form-control"
							placeholder="接口url">
					</div>
					<div id="url_warning" aria-hidden="true" class="alert alert-warning alert-dismissible"
						role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>Warning!</strong> url is invalid!
					</div>

					<div id="sizing-addon2">
						<span style="margin: 15px 15px -5px 0">request method </span> <input
							type="radio" name="method" value="0" checked> get &nbsp;
						&nbsp; &nbsp; &nbsp; <input type="radio" name="method" value="1">
						post
					</div>

					<span id="sizing-addon2">params</span>
					<div style="margin: 20px auto 10px 120px">

						<div class="row">
							<div class="col-xs-4">
								<input name="paramName" type="text" class="form-control"
									placeholder="param1_name">
							</div>
							<div class="col-xs-4">
								<input name="paramValue" type="text" class="form-control"
									placeholder="param1_value">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-4">
								<input name="paramName" type="text" class="form-control"
									placeholder="param2_name">
							</div>

							<div class="col-xs-4">
								<input name="paramValue" type="text" class="form-control"
									placeholder="param2_value">
							</div>
						</div>

						<br>
						<div class="row">
							<div class="col-xs-4">
								<input name="paramName" type="text" class="form-control"
									placeholder="param3_name">
							</div>

							<div class="col-xs-4">
								<input name="paramValue" type="text" class="form-control"
									placeholder="param3_value">
							</div>
						</div>

						<br>
						<div class="row">
							<div class="col-xs-4">
								<input name="paramName" type="text" class="form-control"
									placeholder="param4_name">
							</div>

							<div class="col-xs-4">
								<input name="paramValue" type="text" class="form-control"
									placeholder="param4_value">
							</div>
						</div>

						<br>
						<div class="row">
							<div class="col-xs-4">
								<input name="paramName" type="text" class="form-control"
									placeholder="param5_name">
							</div>

							<div class="col-xs-4">
								<input name="paramValue" type="text" class="form-control"
									placeholder="param5_value">
							</div>
						</div>

						<br>
						<div class="row">
							<div class="col-xs-4">
								<input name="paramName" type="text" class="form-control"
									placeholder="param6_name">
							</div>

							<div class="col-xs-4">
								<input name="paramValue" type="text" class="form-control"
									placeholder="param6_value">
							</div>
						</div>


						<br>
						<div class="row" style="margin-left: 50px">

							<input type="reset" class="btn btn-default" value="清空数据">
							&nbsp; &nbsp; &nbsp; &nbsp;
							<button type="button" class="btn btn-success" id="go_submit">请求接口</button>
						</div>
					</div>

				</form>

			</div>

		</div>
		<div id="result"></div>
	</div>
</body>
<script src="static/bootstrap-3.3.6-dist/js/jquery-2.2.2.min.js"></script>
<script src="static/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

<script src="static/js/main.js"></script>
<script>
	
</script>
</html>
