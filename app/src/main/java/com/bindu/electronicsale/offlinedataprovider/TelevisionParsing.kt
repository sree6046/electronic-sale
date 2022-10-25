package com.bindu.electronicsale.offlinedataprovider

import com.bindu.electronicsale.api.TelevisionsOfflineApi
import com.bindu.electronicsale.model.Television
import com.bindu.electronicsale.model.TelevisionObject

class TelevisionParsing : TelevisionsOfflineApi {

    override suspend fun getTelevisions(): TelevisionObject {
        return TelevisionObject(
            listOf(
                Television(
                    101, "Sony Bravia",
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

                Television(
                    102, "Mi Tv",
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

                Television(
                    103, "Samsung",
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
}