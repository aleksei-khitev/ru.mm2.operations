<div id="contacts${i}" class="phone-div" <g:if test="${hidden}">style="display:none;"</g:if>>
    <g:hiddenField name='contact[${i}].id' value='${contacts?.id}'/>
    <g:hiddenField name='phonesList[${i}].deleted' value='false'/>
    <g:hiddenField name='phonesList[${i}].new' value='false'/>

    <g:textField name='phonesList[${i}].number' value='${contacts?.value}' />
    <g:select name="phonesList[${i}].type"
              from="${ru.mm2.operations.ContactTypes.name()}"
              optionKey="key"
              optionValue="value"
              value = "${contacts?.type?.key}"/>

    <span class="del-phone">
        <img src="${resource(dir:'images/skin', file:'icon_delete.png')}"
             style="vertical-align:middle;"/>
    </span>
</div>