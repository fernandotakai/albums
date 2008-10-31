class AlbumTitleCodec {

    static encode = { albumTitle ->
        albumTitle.replaceAll ' ', '_'
    }

    static decode = { encodedAlbumTitle ->
        encodedAlbumTitle.replaceAll '_', ' '
    }
}