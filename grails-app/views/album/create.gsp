

<html>
    <head>
        <gui:resources components='tabView, richEditor' mode='debug'/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Album</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Album List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Album</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${albumInstance}">
            <div class="errors">
                <g:renderErrors bean="${albumInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="artist">Artist:</label>
                                </td>
                                <td valign="top" class="yui-skin-sam value ${hasErrors(bean:albumInstance,field:'artist','errors')}">
                                    <gui:tabView id='artistTabView'>
                                        <gui:tab label="Existing" active="true">
                                            <g:select optionKey="id" from="${Artist.list()}" name="artist.id" value="${albumInstance?.artist?.id}" ></g:select>
                                        </gui:tab>
                                        <gui:tab label="New">
                                            <input type="text" id='newArtistName' name='newArtistName' />
                                        </gui:tab>
                                    </gui:tabView>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Title:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:albumInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:albumInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
