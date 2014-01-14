<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>"Программа регистрации операций</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}
			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Внутренние ссылки:</h1>
			<ul>
				<li><a href="${createLink(controller: 'doctor', action: 'index')}">Врачи</a></li>
				<li><a href="${createLink(controller: 'operations', action: 'index')}">Операции</a></li>
                <li><a href="${createLink(controller: 'research', action: 'index')}">Исследования</a></li>
                <br/>
                <li><a href="${createLink(controller: 'consultationRecord', action: 'index')}">Бесплатные консультации</a></li>
				<li><a href="${createLink(controller: 'operationRecord', action: 'index')}">Плановая госпитализация</a></li>
                <br/>
                <li><a href="${createLink(controller: 'comConsultationRecord', action: 'index')}">Платные консультации</a></li>
                <li><a href="${createLink(controller: 'comOperationRecord', action: 'index')}">Платная госпитализация</a></li>
                <li><a href="${createLink(controller: 'comResearchRecord', action: 'index')}">Платные медицинские исследования</a></li>
                <br/>
                <li><a href="">Телефоны врачей</a></li>
				<li><a href="http://10.0.2.196/">База знаний</a></li>
			</ul>
			<h1>Внешние ссылки:</h1>
			<ul>
                <li><a href="http://mm2.ru/">Сайт "Городская больница №2"</a></li>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h1>Добро пожаловать!!!</h1>
			<p>Эта программа предназначена для записи на госпитализацию, консультации и медицинские исследования</p>
            <img src="${resource(dir: 'images', file: 'unnamed.jpg')}" alt="" width="600" height="400"/>
		</div>
	</body>
</html>
