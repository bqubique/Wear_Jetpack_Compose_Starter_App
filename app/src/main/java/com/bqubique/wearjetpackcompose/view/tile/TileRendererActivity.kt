package com.bqubique.wearjetpackcompose.view.tile

import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.wear.tiles.manager.TileUiClient
import com.bqubique.wearjetpackcompose.R

class TileRendererActivity : AppCompatActivity() {
    private lateinit var tileUiClient: TileUiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tile_renderer)
        val rootLayout = findViewById<FrameLayout>(R.id.tile_container)
        tileUiClient = TileUiClient(
            context = this,
            component = ComponentName(this, QuranTile::class.java),
            parentView = rootLayout
        )
        tileUiClient.connect()
    }

    override fun onDestroy() {
        super.onDestroy()
        tileUiClient.close()
    }
}