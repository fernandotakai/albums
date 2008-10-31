<ul>
<g:each var="t" in="${tracks}">
    <li>${t?.encodeAsHTML()}</li>
</g:each>
</ul>
