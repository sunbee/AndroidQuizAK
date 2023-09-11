package com.example.androidquiz.ui.knowledgeBase

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun KnowledgeBaseVideo(
    videoId: String,
    startSeconds: Float = 0f,
    modifier: Modifier
) {
    val context = LocalContext.current

    val lifecycleOwner = LocalLifecycleOwner.current

    AndroidView(factory = { context ->
        var view = YouTubePlayerView(context)
        lifecycleOwner.lifecycle.addObserver(view)
        var fragment = view.addYouTubePlayerListener(
            object: AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(videoId, startSeconds)
                }  // end OVERRIDE FUN
            }  // end OBJECT
        )  // end FRAGMENT
        view
    })

}