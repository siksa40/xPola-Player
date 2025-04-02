package com.example.siktv

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var channelList: MutableList<Channel>
    private lateinit var adapter: ChannelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        channelList = mutableListOf(
            Channel("BeIn 1", "http://148.251.133.153:8181/logo/chn/5079.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5079.ts"),
            Channel("BeIn 2", "http://148.251.133.153:8181/logo/chn/5080.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5080.ts"),
            Channel("BeIn 3", "http://148.251.133.153:8181/logo/chn/5081.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5081.ts"),
            Channel("BeIn 4", "http://148.251.133.153:8181/logo/chn/5082.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5082.ts"),
            Channel("BeIn 5", "http://148.251.133.153:8181/logo/chn/5083.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5083.ts"),
            Channel("BeIn 6", "http://148.251.133.153:8181/logo/chn/5084.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5084.ts"),
            Channel("BeIn 7", "http://148.251.133.153:8181/logo/chn/5085.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5085.ts"),
            Channel("BeIn 8", "http://148.251.133.153:8181/logo/chn/5086.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5086.ts"),
            Channel("BeIn 9", "http://ip.magsat.tv:8801/logo/chn/2198", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6528.ts"),
            Channel("BeIn 1", "http://148.251.133.153:8181/logo/chn/5079.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/3404.ts"),
            Channel("BeIn 2", "http://148.251.133.153:8181/logo/chn/5080.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/3405.ts"),
            Channel("BeIn 3", "http://148.251.133.153:8181/logo/chn/5081.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/3406.ts"),
            Channel("BeIn 4", "http://148.251.133.153:8181/logo/chn/5082.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/3407.ts"),
            Channel("BeIn 5", "http://148.251.133.153:8181/logo/chn/5083.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2458.ts"),
            Channel("BeIn 6", "http://148.251.133.153:8181/logo/chn/5084.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/3408.ts"),
            Channel("BeIn 7", "http://148.251.133.153:8181/logo/chn/5085.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/3409.ts"),
            Channel("BeIn 8", "http://148.251.133.153:8181/logo/chn/5086.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/3410.ts"),
            Channel("BeIn 9", "http://ip.magsat.tv:8801/logo/chn/2198", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6528.ts"),
            Channel("BeIn 1", "https://www.lyngsat.com/logo/tv/bb/bein-sports-1-qa.png", "http://live.lynxiptv.xyz/live/303807603986/IwCdbMLRsi/196157.ts"),
            Channel("BeIn 2", "https://www.lyngsat.com/logo/tv/bb/bein-sports-2-qa.png", "http://live.lynxiptv.xyz/live/303807603986/IwCdbMLRsi/196158.ts"),
            Channel("BeIn 3", "https://www.lyngsat.com/logo/tv/bb/bein-sports-3-qa.png", "http://live.lynxiptv.xyz/live/303807603986/IwCdbMLRsi/196159.ts"),
            Channel("BeIn 4", "https://www.lyngsat.com/logo/tv/bb/bein-sports-4-qa.png", "http://live.lynxiptv.xyz/live/303807603986/IwCdbMLRsi/196160.ts"),
            Channel("BeIn 5", "https://www.lyngsat.com/logo/tv/bb/bein-sports-5-qa.png", "http://live.lynxiptv.xyz/live/303807603986/IwCdbMLRsi/196161.ts"),
            Channel("BeIn 6", "https://www.lyngsat.com/logo/tv/bb/bein-sports-6-qa.png", "http://live.lynxiptv.xyz/live/303807603986/IwCdbMLRsi/196162.ts"),
            Channel("BeIn 7", "https://www.lyngsat.com/logo/tv/bb/bein-sports-7-qa.png", "http://live.lynxiptv.xyz/live/303807603986/IwCdbMLRsi/196163.ts"),
            Channel("BeIn 8", "https://www.lyngsat.com/logo/tv/bb/bein-sports-8-qa.png", "http://live.lynxiptv.xyz/live/303807603986/IwCdbMLRsi/196164.ts"),
            Channel("BeIn 9", "https://www.lyngsat.com/logo/tv/bb/bein-sports-9-qa.png", "http://20025.online:2086/live/888420221658/21945814066f91c99369e5/240463.ts"),
            Channel("BeIn 1", "https://prod-media.beinsports.com/image/f50c7035e532c49a0f6993d988e2e843.128.png", "http://20025.online:2086/live/888420221658/21945814066f91c99369e5/240463.ts"),
            Channel("BeIn 2", "https://prod-media.beinsports.com/image/4fbe073f17f161810fdf3dab1307b30f.128.png", "http://20025.online:2086/live/888420221658/21945814066f91c99369e5/240464.ts"),
            Channel("BeIn 3", "https://prod-media.beinsports.com/image/94130ea17023c4837f0dcdda95034b65.128.png", "http://20025.online:2086/live/888420221658/21945814066f91c99369e5/240465.ts"),
            Channel("BeIn 4", "https://prod-media.beinsports.com/image/e92b755eb0d8800175a02a35c2bf44fe.128.png", "http://20025.online:2086/live/888420221658/21945814066f91c99369e5/240466.ts"),
            Channel("BeIn 5", "https://prod-media.beinsports.com/image/0a5052334511e344f15ae0bfafd47a67.128.png", "http://20025.online:2086/live/888420221658/21945814066f91c99369e5/240467.ts"),
            Channel("Al Fajer 1", "https://tv.alfajertv.com/assets/images/logo", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6728.ts"),
            Channel("Al Fajer 2", "https://tv.alfajertv.com/assets/images/logo.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6729.ts"),
            Channel("Al Fajer 3", "https://tv.alfajertv.com/assets/images/logo.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6730.ts"),
            Channel("Al Fajer 4", "https://tv.alfajertv.com/assets/images/logo.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6731.ts"),
            Channel("Al Fajer 5", "https://tv.alfajertv.com/assets/images/logo.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6732.ts"),
            Channel("BeIn 1", "https://www.lyngsat.com/logo/tv/bb/bein-sports-1-qa-fr.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5114.ts"),
            Channel("BeIn 2", "https://www.lyngsat.com/logo/tv/bb/bein-sports-2-qa.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5115.ts"),
            Channel("BeIn 3", "https://www.lyngsat.com/logo/tv/bb/bein-sports-3-qa.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5116.ts"),
            Channel("CANAL+ FOOT", "http://logo.lynxcontents.click/Logo/france/canal-plus-foot-fr.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6561.ts"),
            Channel("CANAL+ SPORT 360", "http://logo.lynxcontents.click/Logo/france/canal-plus-sport-360-fr.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2453.ts"),
            Channel("CANAL", "http://logo.lynxcontents.click/channels/French/canal%2B.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6560.ts"),
            Channel("CANAL+ BOX OFFICE", "https://www.lyngsat.com/logo/tv/cc/canal-plus-box-office-fr.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/4783.ts"),
            Channel("CANAL CINEMA", "http://logo.lynxcontents.click/Logo/france/canalplus_fr_cinema.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/5064.ts"),
            Channel("CANAL SERIE", "https://www.lyngsat.com/logo/tv/bb/bein-sports-9-qa.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2389.ts"),
            Channel("CINE+ FESTIVA", "https://www.lyngsat.com/logo/tv/cc/cineplus-festival-fr.svg", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2489.ts"),
            Channel("CINE+ EMOTION", "http://logo.lynxcontents.click/Logo/france/canalplus_fr_cine_plus_emotion.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2391.ts"),
            Channel("CINE+ FRISSON", "http://logo.lynxcontents.click/Logo/france/canalplus_fr_cine_plus_frisson.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2392.ts"),
            Channel("CINE+ OCS", "https://prod-media.beinsports.com/image/e92b755eb0d8800175a02a35c2bf44fe.128.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/6883.ts"),
            Channel("USHUAIA TV", "http://logo.lynxcontents.click/Logo/france/ushuaia_tv.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2419.ts"),
            Channel("ANIMAUX", "http://logo.lynxcontents.click/Logo/france/animaux_fr.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2414.ts"),
            Channel("CHASSE ET PECHE", "http://logo.lynxcontents.click/Logo/france/chasse_et_peche.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2493.ts"),
            Channel("DISCOVERY", "http://logo.lynxcontents.click/Logo/france/discovery_global_us.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2410.ts"),
            Channel("PLANETE+", "http://logo.lynxcontents.click/Logo/france/planete_plus.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2415.ts"),
            Channel("PLANETE+ AVENTURE", "http://logo.lynxcontents.click/Logo/france/planete_plus_action_experience.png", "http://148.251.133.153:8181/live/N9eSp8k95MieWyC/9sr8aO4rJUZ/2416.ts"),
            Channel("SSC 1", "https://iili.io/JhkQEp1.png", "https://ssc-1-enc.edgenextcdn.net/out/v1/c696e4819b55414388a1a487e8a45ca1/index.mpd")

        )

        adapter = ChannelAdapter(channelList, this) { channel ->
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra("video_url", channel.url)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
