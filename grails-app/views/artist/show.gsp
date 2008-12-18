

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Artist</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Artist List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Artist</g:link></span>
        </div>
        <div class="body">
            <h1>Show Artist</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:artistInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:artistInstance, field:'name')}</td>
                            
                        </tr>
                        <tr class="prop">
                            <td valign="top" class="name">Track Count:</td>                            
                            <td valign="top" class="value">${fieldValue(bean:artistInstance, field:'tracks.size')}</td>                            
                        </tr>                    
                        <tr class="prop">
                            <td valign="top" class="name">Albums:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="a" in="${artistInstance.albums}">
                                    <li><g:link controller="album" 
	                                            action="show" 
	                                            params="[artistName: artistInstance.name.encodeAsArtistName(), albumTitle: a.title.encodeAsAlbumTitle()]">
	${a?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${artistInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
