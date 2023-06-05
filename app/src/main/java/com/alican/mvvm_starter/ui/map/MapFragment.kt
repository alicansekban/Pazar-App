package com.alican.mvvm_starter.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.alican.mvvm_starter.R
import com.alican.mvvm_starter.base.BaseFragment
import com.alican.mvvm_starter.databinding.FragmentMapBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback

class MapFragment:BaseFragment<FragmentMapBinding>(),OnMapReadyCallback {
    private val viewModel by viewModels<MapViewModel>()

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    override fun getLayoutId(): Int  = R.layout.fragment_map

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

    }
}