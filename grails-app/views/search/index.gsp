<%--
  Created by IntelliJ IDEA.
  User: akhitev
  Date: 01.01.14
  Time: 13:40
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<hr/>
<g:if test='${operSearchResult?.results}'>
    <div class="content scaffold-list">
        <h1>Госпитализации</h1>
        <table>
            <thead>
                <tr>
                    <td>ФИО пациента</td>
                    <td>Диагноз</td>
                    <td>Врач</td>
                    <td>Дата</td>
                    <td>Контакт</td>
                    <td>Примечание</td>
                </tr>
            </thead>
            <g:each var='result' in='${operSearchResult.results}'>

                    <tbody>
                            <td>
                                <g:link controller='operationRecord' action='show' id='${result.id}'>
                                    ${result.fio}
                                </g:link>
                            </td>
                            <td>${result.diagnoz}</td>
                            <td>${result.doctor?.fio}</td>
                            <td><g:formatDate date="${result?.date_time}" /></td>
                            <td>${result.formattedPhone}</td>
                            <td>${result.prim}</td>
                    </tbody>
                </div>
            </g:each>
        </table>
    </div>
</g:if>
<g:if test='${comOperSearchResult?.results}'>
    <div class="content scaffold-list">
        <h1>Платные госпитализации</h1>
        <table>
            <thead>
                <tr>
                    <td>ФИО пациента</td>
                    <td>Диагноз</td>
                    <td>Врач</td>
                    <td>Дата</td>
                    <td>Контакт</td>
                    <td>Примечание</td>
                </tr>
            </thead>
    <g:each var='result' in='${comOperSearchResult.results}'>

        <tbody>
        <td>
            <g:link controller='comOperationRecord' action='show' id='${result.id}'>
                ${result.fio}
            </g:link>
        </td>
        <td>${result.diagnoz}</td>
        <td>${result.doctor?.fio}</td>
        <td><g:formatDate date="${result?.date_time}" /></td>
        <td>${result.formattedPhone}</td>
        <td>${result.prim}</td>
        </tbody>
        </div>
    </g:each>
    </table>
</div>
</g:if>
<g:if test='${consSearchResult?.results}'>
    <div class="content scaffold-list">
        <h1>Консультации</h1>
        <table>
            <thead>
                <tr>
                    <td>ФИО пациента</td>
                    <td>Диагноз</td>
                    <td>Врач</td>
                    <td>Дата</td>
                    <td>Контакт</td>
                    <td>Примечание</td>
                </tr>
            </thead>
    <g:each var='result' in='${consSearchResult.results}'>

        <tbody>
        <td>
            <g:link controller='consultationRecord' action='show' id='${result.id}'>
                ${result.fio}
            </g:link>
        </td>
        <td>${result.diagnoz}</td>
        <td>${result.doctor?.fio}</td>
        <td><g:formatDate date="${result?.date_time}" /></td>
        <td>${result.formattedPhone}</td>
        <td>${result.prim}</td>
        </tbody>
        </div>
    </g:each>
    </table>
</div>
</g:if>
    <g:if test='${comConsSearchResult?.results}'>
        <div class="content scaffold-list">
            <h1>Платные консультации</h1>
            <table>
                <thead>
                    <tr>
                        <td>ФИО пациента</td>
                        <td>Диагноз</td>
                        <td>Врач</td>
                        <td>Дата</td>
                        <td>Контакт</td>
                        <td>Примечание</td>
                    </tr>
                </thead>
        <g:each var='result' in='${comConsSearchResult.results}'>

            <tbody>
            <td>
                <g:link controller='comConsultationRecord' action='show' id='${result.id}'>
                    ${result.fio}
                </g:link>
            </td>
            <td>${result.diagnoz}</td>
            <td>${result.doctor?.fio}</td>
            <td><g:formatDate date="${result?.date_time}" /></td>
            <td>${result.formattedPhone}</td>
            <td>${result.prim}</td>
            </tbody>
            </div>
        </g:each>
        </table>
    </div>
</g:if>
<g:if test='${comResearchSearchResult?.results}'>
    <div class="content scaffold-list">
        <h1>Платные исследования</h1>
        <table>
            <thead>
                <tr>
                    <td>ФИО пациента</td>
                    <td>Исследование</td>
                    <td>Дата иследования</td>
                    <td>Дата рождения</td>
                </tr>
            </thead>
    <g:each var='result' in='${comResearchSearchResult.results}'>

        <tbody>
        <td>
            <g:link controller='comResearchRecord' action='show' id='${result.id}'>
                ${result?.fio}
            </g:link>
        </td>
        <td>${result?.research?.name}</td>
        <td>${result?.date_time}</td>
        <td><g:formatDate date="${result?.birthday}" /></td>
        </tbody>
        </div>
    </g:each>
    </table>
</div>
</g:if>
<g:if test='${doctorSearchResult?.results}'>
    <div class="content scaffold-list">
        <h1>Врачи</h1>
        <table>
            <thead>
                <tr>
                    <td>ФИО</td>
                    <td>Должность</td>
                    <td>Местный телефон</td>
                    <td>Электронная почта</td>
                </tr>
            </thead>
    <g:each var='result' in='${doctorSearchResult.results}'>
        <tbody>
        <td>
            <g:link controller='doctor' action='show' id='${result.id}'>
                ${result?.fio}
            </g:link>
        </td>
        <td>${result?.rang}</td>
        <td>${result?.localphone}</td>
        <td>${result?.email}</td>
        </tbody>
        </div>
    </g:each>
    </table>
</div>
</g:if>
</body>
</html>