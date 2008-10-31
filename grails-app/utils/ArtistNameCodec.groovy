class ArtistNameCodec {

    static encode = { artistName ->
        artistName.replaceAll ' ', '_'
    }

    static decode = { encodedArtistName ->
        encodedArtistName.replaceAll '_', ' '
    }
}