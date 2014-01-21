<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Программа регистрации операций"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<g:layoutHead/>
		<g:javascript library="application"/>
		<r:layoutResources />
	</head>
	<body>
    <div style="background-color: #1E90FF" align="right">
        <sec:ifNotLoggedIn>
            <g:link controller="login" action="auth">Войти</g:link>
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
            Вы вошли как <b style="font-size: 15px"><sec:username/></b><br/>
            <g:link controller="logout">Выход</g:link>
        </sec:ifLoggedIn>
    </div>

    <section class="tabs" style="background-color: #1E90FF">
        <input id="tab_1" type="radio" name="tab" checked="checked" />
        <input id="tab_2" type="radio" name="tab" />
        <input id="tab_3" type="radio" name="tab" />
        <sec:ifAllGranted roles="ROLE_ROOT">
            <input id="tab_4" type="radio" name="tab" />
        </sec:ifAllGranted>
        <label for="tab_1" id="tab_l1">Бесплатное отделение</label>
        <label for="tab_2" id="tab_l2" style="background-color: forestgreen;">Платное отделение</label>
        <label for="tab_3" id="tab_l3" style="background-color: coral;">Общие данные</label>
        <sec:ifAllGranted roles="ROLE_ROOT">
            <label for="tab_4" id="tab_l4" style="background-color: darkred; color: white">Сервис</label>
        </sec:ifAllGranted>
        <div style="clear:both"></div>
        <div class="tabs_cont">
            <div id="tab_c1">
                <div id="grailsLogo1" role="banner">
                    <table>
                        <tr style="background-color: mediumpurple">
                            <td>
                                <a href="${createLink(url: '/ru.mm2.operations/')}"><img src="${resource(dir: 'images', file: 'logo.jpg')}" alt="Детская больница №2 Святой Марии Магдалины"/></a>
                            </td>
                            <td>
                                <g:link controller="consultationRecord" class="home">
                                    <img src="${resource(dir: 'images', file: 'shedulder.png')}" alt="Консультации" width="70" height="70"/><br>
                                    <h4 style="color:#F0FFFF">Запись на <br>консультацию</h4>
                                </g:link>
                            </td>
                            <td>
                                <g:link controller="genOperationRecord" class="home">
                                    <img src="${resource(dir: 'images', file: 'shedulder.png')}" alt="Госпитализации" width="70" height="70"/><br>
                                    <h4 style="color:#F0FFFF">Запись на <br>госпитализацию</h4>
                                </g:link>
                            </td>
                        </tr>
                    </table>

                </div>
             </div>
            <div id="tab_c2">
                <div id="grailsLogo2" role="banner">

                    <table>
                        <tr style="background-color: forestgreen">
                            <td>
                                <a href="${createLink(url: '/ru.mm2.operations/')}"><img src="${resource(dir: 'images', file: 'logo.jpg')}" alt="Детская больница №2 Святой Марии Магдалины"/></a>
                            </td>
                            <td>
                                <g:link controller="comConsultationRecord" class="home">
                                    <img src="${resource(dir: 'images', file: 'shedulder.png')}" alt="Консультации" width="70" height="70"/><br>
                                    <h4 style="color:#F0FFFF">Запись на <br>консультацию</h4>
                                </g:link>
                            </td>
                            <td>
                                <g:link controller="comOperationRecord" class="home">
                                    <img src="${resource(dir: 'images', file: 'shedulder.png')}" alt="Госпитализации" width="70" height="70"/><br>
                                    <h4 style="color:#F0FFFF">Запись на <br>госпитализацию</h4>
                                </g:link>
                            </td>
                            <td>
                                <g:link controller="comResearchRecord" class="home">
                                    <img src="${resource(dir: 'images', file: 'shedulder.png')}" alt="Госпитализации" width="70" height="70"/><br>
                                    <h4 style="color:#F0FFFF">Запись на <br>исследования</h4>
                                </g:link>
                            </td>
                        </tr>
                    </table>

                </div>
            </div>
            <div id="tab_c3">
                <div id="grailsLogo3" role="banner">

                    <table>
                        <tr style="background-color: coral">
                            <td>
                                <a href="${createLink(url: '/ru.mm2.operations/')}"><img src="${resource(dir: 'images', file: 'logo.jpg')}" alt="Детская больница №2 Святой Марии Магдалины"/></a>
                            </td>
                            <td>
                                <g:link controller="doctor" class="home">
                                    <img src="${resource(dir: 'images', file: 'doctor.png')}" alt="Врачи1" width="70" height="70"/><br>
                                    <h4 style="color:#F0FFFF">Врачи</h4>
                                </g:link>
                            </td>
                            <td>
                                <g:link controller="operations" class="home">
                                    <img src="${resource(dir: 'images', file: 'operations.png')}" alt="Операции" width="70" height="70"/><br>
                                    <h4 style="color:#F0FFFF">Операции</h4>
                                </g:link>
                            </td>
                            <td>
                                <g:link controller="research" class="home">
                                    <img src="${resource(dir: 'images', file: 'research.jpg')}" alt="Операции" width="70" height="70"/><br>
                                    <h4 style="color:#F0FFFF">Исследования</h4>
                                </g:link>
                            </td>
                        </tr>
                    </table>

                </div>
            </div>
            <sec:ifAllGranted roles="ROLE_ROOT">
                <div id="tab_c4">
                    <div id="grailsLogo4" role="banner">
                        <table>
                            <tr style="background-color: darkred">
                                <td>
                                    <a href="${createLink(url: '/ru.mm2.operations/')}"><img src="${resource(dir: 'images', file: 'logo.jpg')}" alt="Детская больница №2 Святой Марии Магдалины"/></a>
                                </td>
                                <td>
                                    <g:link controller="secUser" class="home">
                                        <img src="${resource(dir: 'images', file: 'shedulder.png')}" alt="Пользователи" width="70" height="70"/><br>
                                        <h4 style="color:#F0FFFF">Редактирование <br>пользователей</h4>
                                    </g:link>
                                </td>
                                <td>
                                    <g:link controller="secRole" class="home">
                                        <img src="${resource(dir: 'images', file: 'shedulder.png')}" alt="Роли" width="70" height="70"/><br>
                                        <h4 style="color:#F0FFFF">Редактирование <br>ролей политики</h4>
                                    </g:link>
                                </td>
                            </tr>
                        </table>

                    </div>
                </div>
            </sec:ifAllGranted>
        </div>

    </section>

		<g:layoutBody/>
		<div class="footer" role="contentinfo">
            <g:form action="index" controller="search">
                <input type="search" name="q" placeholder="поиск" results=5 style="border-radius: 20px;"/>
            </g:form>
		</div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<r:layoutResources />
	</body>
</html>
