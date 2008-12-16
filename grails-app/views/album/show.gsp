

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Album</title>
		<g:javascript library="prototype" />
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Album List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Album</g:link></span>
        </div>
        <div class="body">
            <h1>Show Album</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:albumInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Artist:</td>
                            
                            <td valign="top" class="value">
	                          <g:link controller="artist" 
	                                  action="show"
	                                  params="[artistName: albumInstance?.artist?.name.encodeAsArtistName()]">
	${albumInstance?.artist?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Title:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:albumInstance, field:'title')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tracks:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
	<div id="trackList">
		<g:render template="tracks" model="[tracks: albumInstance.tracks]"/>
		</div>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table>
<h1>Add Track To Album</h1>
<g:formRemote url="[action: 'addTrack']" update="trackList" name="addTrack">
	<g:textField name="trackName" value=""/>
	<g:hiddenField name="albumId" value="${albumInstance.id}"/>
</g:formRemote>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${albumInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
