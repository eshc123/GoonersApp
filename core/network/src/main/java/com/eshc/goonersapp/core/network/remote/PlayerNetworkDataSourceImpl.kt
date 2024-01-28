package com.eshc.goonersapp.core.network.remote

import android.util.Log
import com.eshc.goonersapp.core.network.PlayerNetworkDataSource
import com.eshc.goonersapp.core.network.api.PlayerNetworkService
import com.eshc.goonersapp.core.network.model.RemotePlayer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerNetworkDataSourceImpl @Inject constructor(
    private val playerNetworkService: PlayerNetworkService
) : PlayerNetworkDataSource {


    override suspend fun getPlayerList(): List<RemotePlayer> {
        return try {
            val response = playerNetworkService.getPlayers()
            if(response.isSuccessful){
                response.body()?.result ?: emptyList()
            }else emptyList()
        }catch (e:Exception){
            emptyList()
        }
    }

    override suspend fun getPlayerDetail(playerId: Int): RemotePlayer {
        return try {
            val response = playerNetworkService.getPlayerDetail(playerId = playerId)
            if(response.isSuccessful){
                response.body()?.result ?: RemotePlayer(-1)
            }else RemotePlayer(-1)
        }catch (e:Exception){
            RemotePlayer(-1)
        }
    }

}

//val dummy = listOf(
//    RemotePlayer(
//        id = "1",
//        name = "Aaron\nRamsdale",
//        backNumber = 1,
//        position = "GK",
//        birthDate = "1998-05-14",
//        height = 190,
//        weight = 88,
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Ramsdale_1510x850_0.jpg?auto=webp&itok=w6EQqPOI"
//    ),
//    RemotePlayer(
//        id = "22",
//        name = "David\nRaya",
//        backNumber = 22,
//        position = "GK",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Raya%20website%20profile%20image.png?auto=webp&itok=qs9f8267"
//    ),
//    RemotePlayer(
//        id = "31",
//        name = "Karl\nHein",
//        backNumber = 31,
//        position = "GK",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Hein_1510x850_0.jpg?auto=webp&itok=Olojclw9"
//    ),
//    RemotePlayer(
//        id = "2",
//        name = "Willam\nSaliba",
//        backNumber = 2,
//        position = "DF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/MicrosoftTeams-image%20%2831%29_0.png?auto=webp&itok=zY0rjgVn"
//    ),
//    RemotePlayer(
//        id = "4",
//        name = "Ben\nWhite",
//        backNumber = 4,
//        position = "DF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_White_1510x850_0.jpg?auto=webp&itok=iUyWTT7l"
//    ),
//    RemotePlayer(
//        id = "6",
//        name = "Gabriel\nMagalhaes",
//        backNumber = 6,
//        position = "DF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Gabriel_1510x850_0.jpg?auto=webp&itok=_bv57iX5"
//    ),
//    RemotePlayer(
//        id = "12",
//        name = "Jurrien\nTimber",
//        backNumber = 12,
//        position = "DF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/MicrosoftTeams-image%20%2827%29_0.png?auto=webp&itok=9GPY-bZ8"
//    ),
//    RemotePlayer(
//        id = "15",
//        name = "Yakub\nKiwior",
//        backNumber = 15,
//        position = "DF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Kiwior_1510x850_0.jpg?auto=webp&itok=iGge9AQ8"
//    ),
//    RemotePlayer(
//        id = "17",
//        name = "Cedric\nSoares",
//        backNumber = 17,
//        position = "DF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/MicrosoftTeams-image%20%2828%29_1.png?auto=webp&itok=tiiU8DLt"
//    ),
//    RemotePlayer(
//        id = "18",
//        name = "Takehiro\nTomiyasu",
//        backNumber = 18,
//        position = "DF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/MicrosoftTeams-image%20%2832%29_0.png?auto=webp&itok=i6UFe3mR"
//    ),
//    RemotePlayer(
//        id = "35",
//        name = "Oleksandr\nZinchenko",
//        backNumber = 35,
//        position = "DF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Zinchenko_1510x850_0.jpg?auto=webp&itok=xxf95c-H"
//    ),
//    RemotePlayer(
//        id = "5",
//        name = "Thomas\nPartey",
//        backNumber = 5,
//        position = "MF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Partey_1510x850_0.jpg?auto=webp&itok=l8_scPxh"
//    ),
//    RemotePlayer(
//        id = "8",
//        name = "Martin\nOdegaard",
//        backNumber = 8,
//        position = "MF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Odegaard_1510x850_0.jpg?auto=webp&itok=YQO9ByvO"
//    ),
//
//    RemotePlayer(
//        id = "10",
//        name = "Emile\nSmith Rowe",
//        backNumber = 10,
//        position = "MF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_SmithRowe_1510x850_0.jpg?auto=webp&itok=Inf1oGOt"
//    ),
//    RemotePlayer(
//        id = "20",
//        name = "Jorginho",
//        backNumber = 20,
//        position = "MF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Jorginho_1510x850_0.jpg?auto=webp&itok=Nf9aKZ1_"
//    ),
//    RemotePlayer(
//        id = "21",
//        name = "Fabio\nVieira",
//        backNumber = 21,
//        position = "MF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Vieira_1510x850_0.jpg?auto=webp&itok=IU_d4QjL"
//    ),
//    RemotePlayer(
//        id = "25",
//        name = "Mohamed\nElneny",
//        backNumber = 25,
//        position = "MF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Elneny_1510x850_0.jpg?auto=webp&itok=vB0SjbIG"
//    ),
//    RemotePlayer(
//        id = "29",
//        name = "Kai\nHavertz",
//        backNumber = 29,
//        position = "MF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Havertz_1510x850_0.jpg?auto=webp&itok=iTguU7_8"
//    ),
//    RemotePlayer(
//        id = "41",
//        name = "Declan\nRice",
//        backNumber = 41,
//        position = "MF",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/MicrosoftTeams-image%20%2826%29.png?auto=webp&itok=K8hmFn_d"
//    ),
//    RemotePlayer(
//        id = "7",
//        name = "Bukayo\nSaka",
//        backNumber = 7,
//        position = "FW",
//        birthDate = "2001-09-05",
//        height = 178,
//        weight = 72,
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Saka_1510x850_0.jpg?auto=webp&itok=yZpptHcr"
//    ),
//    RemotePlayer(
//        id = "9",
//        name = "Gabriel\nJesus",
//        backNumber = 9,
//        position = "FW",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Jesus_1510x850_0.jpg?auto=webp&itok=ATg3CJe1"
//    ),
//    RemotePlayer(
//        id = "11",
//        name = "Gabriel\nMartinelli",
//        backNumber = 11,
//        position = "FW",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Martinelli_1510x850.jpg?auto=webp&itok=gAO5wDqg"
//    ),
//    RemotePlayer(
//        id = "14",
//        name = "Eddie\nNketiah",
//        backNumber = 14,
//        position = "FW",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Nketiah_1510x850_0.jpg?auto=webp&itok=k3BjsLa_"
//    ),
//    RemotePlayer(
//        id = "19",
//        name = "Leandro\nTrossard",
//        backNumber = 19,
//        position = "FW",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Trossard_1510x850_0.jpg?auto=webp&itok=VEq3JA_C"
//    ),
//    RemotePlayer(
//        id = "24",
//        name = "Reiss\nNelson",
//        backNumber = 24,
//        position = "FW",
//        imageUrl = "https://www.arsenal.com/sites/default/files/styles/large_16x9/public/images/Headshot_Nelson_1510x850_0.jpg?auto=webp&itok=0UCRfAz2"
//    ),
//)