package com.example.siktv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.siktv.databinding.ActivityPlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializePlayer()
    }

    private fun initializePlayer() {
        val videoUrl = intent.getStringExtra("video_url") ?: ""

        // إنشاء ExoPlayer
        player = ExoPlayer.Builder(this).build()
        binding.playerView.player = player

        // إعداد DataSourceFactory مع User-Agent
        val httpDataSourceFactory = DefaultHttpDataSource.Factory()
            .setUserAgent("Mozilla/5.0 (Android 10; Mobile; rv:91.0) Gecko/91.0 Firefox/91.0")
            .setAllowCrossProtocolRedirects(true)

        val dataSourceFactory = DefaultDataSource.Factory(this, httpDataSourceFactory)

        // تحديد نوع MediaSource (HLS أو MP4)
        val mediaSource: MediaSource = if (videoUrl.endsWith(".m3u8")) {
            HlsMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(videoUrl))
        } else {
            ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(videoUrl))
        }

        // تشغيل الفيديو
        player?.setMediaSource(mediaSource)
        player?.prepare()
        player?.play()
    }

    override fun onStop() {
        super.onStop()
        player?.release()
        player = null
    }
}
