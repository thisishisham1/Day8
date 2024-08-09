package klivvr.test.day8.presentation.productListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import klivvr.test.day8.R
import klivvr.test.day8.data.remoteDataSource.retrofit.RetrofitService
import klivvr.test.day8.data.remoteDataSource.source.RemoteDataSourceImpl
import klivvr.test.day8.data.repository.Repository
import klivvr.test.day8.viewModel.MainViewModel
import klivvr.test.day8.viewModel.MainViewModelFactory

class ListProductFragment : Fragment() {
    private val repository = Repository(RemoteDataSourceImpl(RetrofitService.service))

    private val vm: MainViewModel by viewModels (
        factoryProducer = { MainViewModelFactory(repository) }
    )
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = ProductAdapter(vm.productList.value.orEmpty())

        vm.productList.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
        recyclerView.adapter = adapter
        super.onViewCreated(view, savedInstanceState)
    }
}