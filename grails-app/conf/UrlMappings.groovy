class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
	  
	  "/showAlbum/$artistName/$albumTitle"(controller: 'album', action: 'show')
	  "/showArtist/$artistName"(controller: 'artist', action: 'show')
	  
	  "500"(view:'/error')
	}
}
