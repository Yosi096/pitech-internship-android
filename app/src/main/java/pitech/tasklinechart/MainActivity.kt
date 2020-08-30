package pitech.tasklinechart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? =null
    private var adapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>? = null
//    private lateinit var lineAdapter: LineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager
        adapter = RecyclerViewAdapter()
        recycler.adapter = adapter


//        val dataLine = item(4)
//        recycler.layoutManager = LinearLayoutManager(this)
//        recycler.adapter = RecyclerViewAdapter(dataLine)
//        recycler.setHasFixedSize(true)
//
//        LineAdapter()
//        val retrofit : Retrofit = Retrofit.Builder()
//            .baseUrl("https://private-d96747-pitech.apiary-mock.comintern/graph/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//
//        val apiLine = retrofit.create(ApiLine::class.java)
//        apiLine.getLine()
//            .subscribeOn(Schedulers.io())
//            .unsubscribeOn(Schedulers.computation())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                var lineResponse : LineResponse = it
//            }, {
//
//            })
//
//        // data to populate the RecyclerView with
//        val data: ArrayList<Int> = ArrayList()
//        data.add(1)
//        data.add(1)
//        data.add(1)
//        data.add(1)
//        data.add(1)
//        data.add(1)
    }

//    private fun item(size: Int): List<Line> {
//        val list = ArrayList<Line>()
////        val item2 = Line(2,13,13,13,13)
////        val item3 = Line(3,14,14,14,14)
////        val item4 = Line(4,15,15,15,15)
//        val item = Line(1,12,12,12,12)
//        list += item
//        return list
//    }
//
//    inner class LineAdapter : RecyclerView.Adapter<LineAdapter.LineViewHolder>() {
//        private val lines: List<Line> = mutableListOf()
//        private val itemtitles = arrayOf("Amonia", "Karbondioksida", "Temperature", "Kelembapan")
//        private val sub1 = arrayOf("Waktu dalam jam")
//        private val  sub2 = arrayOf("ppm", "ppm", "C","%")
//
//        inner class LineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//            var textTitle: TextView
//            var textSub1: TextView
//            var textSub2: TextView
//            var mpLineChart: LineChart
//
//            init {
//                textTitle = itemView.findViewById(R.id.tv_title)
//                textSub1 = itemView.findViewById(R.id.tv_sub1)
//                textSub2 = itemView.findViewById(R.id.tv_sub2)
//                mpLineChart = itemView.findViewById(R.id.line_chart)
//            }
//
//            fun bindModel(line: Line){
//
//            }
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
//            return LineViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false))
//        }
//
//        override fun getItemCount(): Int {
//            return itemtitles.size
//        }
//
//        override fun onBindViewHolder(holder: LineViewHolder, position: Int) {
//            holder.textTitle.text =itemtitles[position]
//            holder.textSub1.text =sub1[0]
//            holder.textSub2.text = sub2[position]
//            holder.bindModel(lines[position])
//
//            holder.mpLineChart.description.isEnabled = false
//            holder.mpLineChart.setTouchEnabled(true)
//            holder.mpLineChart.setPinchZoom(true)
//            holder.mpLineChart.setDrawGridBackground(false)
//            holder.mpLineChart.setScaleEnabled(true)
//            holder.mpLineChart.isDragEnabled = true
//            holder.mpLineChart.animateX(2000)
//
//            holder.mpLineChart.setNoDataText("No Data")
//            holder.mpLineChart.setNoDataTextColor(Color.parseColor("#70551F"))
//
//            val entries = ArrayList<Entry>()
//            entries.add(Entry(22f, 26f))
//            entries.add(Entry(21f, 22f))
//            entries.add(Entry(32f, 28f))
//            entries.add(Entry(33f, 25f))
//            entries.add(Entry(35f, 26f))
//            entries.add(Entry(23f, 23f))
//            entries.add(Entry(23.2f, 23.2f))
//            entries.add(Entry(23.3f, 23.4f))
//
//            val lineDataSet = LineDataSet(entries, "data 1")
//            lineDataSet.setDrawCircles(true)
//            lineDataSet.lineWidth = 1f
//            lineDataSet.setColor(Color.parseColor("#70551F"))
//            lineDataSet.circleHoleColor = Color.parseColor("#70551F")
//            lineDataSet.setDrawValues(false)
//            lineDataSet.circleRadius = 5f
//            lineDataSet.setCircleColors(Color.parseColor("#70551F"))
//            holder.mpLineChart.data = LineData(lineDataSet)
//            val legend = holder.mpLineChart.legend
//            legend.isEnabled = false
//
//            val ll1 = LimitLine(22f, "Batas Aman Bawah")
//            ll1.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
//            ll1.textSize = 10f
//            ll1.lineWidth = 3f
//            ll1.lineColor = Color.parseColor("#DDA533")
//
//            val ll2 = LimitLine(27f, "Batas Aman Atas")
//            ll2.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
//            ll2.textSize = 10f
//            ll2.lineWidth = 3f
//            ll2.lineColor = Color.parseColor("#B21B36")
//
//            val xAxis: XAxis = holder.mpLineChart.xAxis
//            xAxis.setAvoidFirstLastClipping(true)
//            xAxis.position = XAxis.XAxisPosition.BOTTOM
//            xAxis.granularity = 1f
//            xAxis.setDrawGridLines(true)
//            xAxis.setDrawAxisLine(false)
//            xAxis.axisMinimum = 0f
//            xAxis.axisMaximum  = 44f
//
//            var yAxis: YAxis = holder.mpLineChart.axisLeft
//            yAxis.setDrawGridLines(true)
//            yAxis.isEnabled = true
//            yAxis.removeAllLimitLines()
//            yAxis.axisMaximum = 28f
//            yAxis.axisMinimum = 21f
//            yAxis.resetAxisMaximum()
//            yAxis.setDrawAxisLine(false)
//
//            yAxis.setDrawLimitLinesBehindData(true)
//            xAxis.setDrawLimitLinesBehindData(true)
//            yAxis.addLimitLine(ll1)
//            yAxis.addLimitLine(ll2)
//
//            holder.mpLineChart.axisRight.isEnabled = false
//            holder.mpLineChart.isAutoScaleMinMaxEnabled = true
//            holder.mpLineChart.notifyDataSetChanged()
//            holder.mpLineChart.invalidate()
//        }
//    }
//
////    fun getDataFromServer() {
////        val url = "https://private-d96747-pitech.apiary-mock.comintern/graph"
////    }

}