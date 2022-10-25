package com.bindu.electronicsale.source

import com.bindu.electronicsale.api.TelevisionsApi
import com.bindu.electronicsale.model.Television
import com.bindu.electronicsale.model.TelevisionObject

class ManualParsing : TelevisionsApi
{

    override suspend fun getTelevisions(): TelevisionObject
    {
        return TelevisionObject(listOf(
            Television("Sony Bravia",
                "Offering a complete cinematic experience " +
                        "at home you can buy Mi 4A/4C Pro 80cm (32 Inch) " +
                        "HD Ready LED Android Smart TV. It is said to be " +
                        "India’s Smartest Android TV. HD-Ready display, " +
                        "cinematic quality sound, multiple ports ensure " +
                        "leading performance. Explore every detail " +
                        "in brilliant clarity, along with life-like colors " +
                        "and enhanced brightness. Uncover every detail" +
                        " with vivid colors and enhanced brightness. " +
                        "PatchWall comes with massive content. ",
                2022,
                45000.00),

            Television("Mi Tv",
                "Offering a complete cinematic experience " +
                        "at home you can buy Mi 4A/4C Pro 80cm (32 Inch) " +
                        "HD Ready LED Android Smart TV. It is said to be " +
                        "India’s Smartest Android TV. HD-Ready display, " +
                        "cinematic quality sound, multiple ports ensure " +
                        "leading performance. Explore every detail " +
                        "in brilliant clarity, along with life-like colors " +
                        "and enhanced brightness. Uncover every detail" +
                        " with vivid colors and enhanced brightness. " +
                        "PatchWall comes with massive content. ",
                2022,
                23000.00),

            Television("Samsung",
                "Offering a complete cinematic experience " +
                        "at home you can buy Mi 4A/4C Pro 80cm (32 Inch) " +
                        "HD Ready LED Android Smart TV. It is said to be " +
                        "India’s Smartest Android TV. HD-Ready display, " +
                        "cinematic quality sound, multiple ports ensure " +
                        "leading performance. Explore every detail " +
                        "in brilliant clarity, along with life-like colors " +
                        "and enhanced brightness. Uncover every detail" +
                        " with vivid colors and enhanced brightness. " +
                        "PatchWall comes with massive content. ",
                2022,
                32000.00)

        )
        )
    }

    override suspend fun getTelevision(): Television
    {
        return           Television("Mi Tv",
            "Offering a complete cinematic experience " +
                    "at home you can buy Mi 4A/4C Pro 80cm (32 Inch) " +
                    "HD Ready LED Android Smart TV. It is said to be " +
                    "India’s Smartest Android TV. HD-Ready display, " +
                    "cinematic quality sound, multiple ports ensure " +
                    "leading performance. Explore every detail " +
                    "in brilliant clarity, along with life-like colors " +
                    "and enhanced brightness. Uncover every detail" +
                    " with vivid colors and enhanced brightness. " +
                    "PatchWall comes with massive content. ",2022, 23000.00)
    }


    /*
      override suspend fun getMovies(): MovieObject
    {
        return MovieObject(listOf(
        Movie("Dog", 2022,"https://source.unsplash.com/user/c_v_r/1900x800",)
        ))
        /*
        try {
            val url = URL("https://jsonparsingdemo-cec5b.firebaseapp.com/json/moviesDemoItem.json")
            val connection = url.openConnection()
            connection.connect()

            val inputStream = BufferedInputStream(url.openStream())
            val bufferedReader = inputStream.bufferedReader()

            val stringBuffer = StringBuffer()

            for (line in bufferedReader.readLines()) {
                stringBuffer.append(line)
            }
            bufferedReader.close()

            // JSON parsing
            val json = stringBuffer.toString()

            return Gson().fromJson(json, MovieObject::class.java)

//            val topLevelObject = JSONObject(json)
//            val moviesArray = topLevelObject.getJSONArray("movies")
//            val movieObject = moviesArray.getJSONObject(0)
//            val movieName = movieObject.getString("movie")
//            val movieYear = movieObject.getInt("year")
//            return MovieObject(listOf(Movie(movieName.plus(" From manual parsing"), movieYear)))
        } catch (e: Exception) {
            return MovieObject(emptyList())
        }

         */
    }

    override suspend fun getMovie(): Movie
    {
        return Movie("Dog", 2022,"https://images.unsplash.com/photo-1612177241462-d254edf4e823?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=800&ixid=MnwxfDB8MXxyYW5kb218MHx8fHx8fHx8MTY2NjUxNTAxMA&ixlib=rb-4.0.3&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=1900")

        /*
        try {
            val url = URL("https://jsonparsingdemo-cec5b.firebaseapp.com/json/movie.json")
            val connection = url.openConnection()
            connection.connect()

            val inputStream = BufferedInputStream(url.openStream())
            val bufferedReader = inputStream.bufferedReader()

            val stringBuffer = StringBuffer()

            for (line in bufferedReader.readLines()) {
                stringBuffer.append(line)
            }
            bufferedReader.close()

            // JSON parsing
            val json = stringBuffer.toString()

            return Gson().fromJson(json, Movie::class.java)

//            val topLevelObject = JSONObject(json)
//            val moviesArray = topLevelObject.getJSONArray("movies")
//            val movieObject = moviesArray.getJSONObject(0)
//            val movieName = movieObject.getString("movie")
//            val movieYear = movieObject.getInt("year")
//            return MovieObject(listOf(Movie(movieName.plus(" From manual parsing"), movieYear)))
        } catch (e: Exception) {
            return Movie("", -1, "")
        }

         */
    }
     */
}