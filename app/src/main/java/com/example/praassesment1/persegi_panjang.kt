package com.example.praassesment1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.about.*
import kotlinx.android.synthetic.main.fragment_persegiPanjang.*


class persegi_panjang : Fragment() {
    private lateinit var binding: persegi_panjang
    private var panjang: Double = 0.00
    private var lebar: Double = 0.00
    private var luas: Double = 0.00
    private var keliling: Double = 0.00

    companion object {
        const val KEY_LUAS = "key_luas"
        const val KEY_KELILING = "key_keliling"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_persegiPanjang, container, false)
        if (savedInstanceState != null) {
            luas = savedInstanceState.getDouble(KEY_LUAS)
            keliling = savedInstanceState.getDouble(KEY_KELILING)
        }
        binding.bt_hitungPP.setOnClickListener{
            if (binding.panjang_pp.text.toString().isEmpty() || binding.lebar_pp.text.toString().isEmpty()){
                Toast.makeText(this,activity,"Field tidak boleh kosong",Toast.LENGTH_SHORT).show()
            }else{
                panjang = binding.panjang_pp.text.toString().toDouble()
                lebar = binding.lebar_pp.text.toString().toDouble()
                keliling = 2 * (panjang + lebar)
                binding.tv_hasil.text = "Luas = $luas"
                binding.tv_hasil.text = "Keliling = $keliling"
            }
        }
        binding.bt_share.setOnClickListener{
            val luaspersegi_panjang = tv_hasil.text.toString()
            val keliling = tv_hasil.text.toString()
            val share = Intent()
            share.action = Intent.ACTION_SEND
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT,luaspersegi_panjang+"\n"+keliling)
            share.putExtra(Intent.EXTRA_SUBJECT,"Hasil Hitung")
            startActivity(Intent.createChooser(share,"Share via...."))
        }
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble(KEY_LUAS,luas)
        outState.putDouble(KEY_KELILING,keliling)
    }

    private fun updateNilai (sl:Double,s2 : Double){
        binding.tv_hasil.setText("Luas= " + sl.toString())
        binding.tv_hasil.setText("Keliling= " + s2.toString())

    }


}