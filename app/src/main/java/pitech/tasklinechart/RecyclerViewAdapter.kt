package pitech.tasklinechart

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.util.ArrayList

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val itemtitles = arrayOf("Amonia", "Karbondioksida", "Temperature", "Kelembapan")
    private val sub1 = arrayOf("Waktu dalam jam")
    private val  sub2 = arrayOf("ppm", "ppm", "C","%")

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textTitle: TextView
        var textSub1: TextView
        var textSub2: TextView
        var mpLineChart: LineChart

        init {
            textTitle = itemView.findViewById(R.id.tv_title)
            textSub1 = itemView.findViewById(R.id.tv_sub1)
            textSub2 = itemView.findViewById(R.id.tv_sub2)
            mpLineChart = itemView.findViewById(R.id.line_chart)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemtitles.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.textTitle.text =itemtitles[position]
        holder.textSub1.text =sub1[0]
        holder.textSub2.text = sub2[position]

        holder.mpLineChart.description.isEnabled = false
        holder.mpLineChart.setTouchEnabled(true)
        holder.mpLineChart.setPinchZoom(true)
        holder.mpLineChart.setDrawGridBackground(false)

        holder.mpLineChart.setNoDataText("No Data")
        holder.mpLineChart.setNoDataTextColor(Color.parseColor("#70551F"))

        val entries = ArrayList<Entry>()
        entries.add(Entry(22f, 26f))
        entries.add(Entry(21f, 22f))
        entries.add(Entry(32f, 28f))
        entries.add(Entry(33f, 25f))
        entries.add(Entry(35f, 26f))
        entries.add(Entry(23f, 23f))
        entries.add(Entry(23.2f, 23.2f))
        entries.add(Entry(23.3f, 23.4f))

        val lineDataSet = LineDataSet(entries, "data 1")
        lineDataSet.setDrawCircles(true)
        lineDataSet.lineWidth = 1f
        lineDataSet.setColor(Color.parseColor("#70551F"))
        lineDataSet.circleHoleColor = Color.parseColor("#70551F")
        lineDataSet.setDrawValues(false)
        lineDataSet.circleRadius = 5f
        lineDataSet.setCircleColors(Color.parseColor("#70551F"))
        holder.mpLineChart.data = LineData(lineDataSet)
        val legend = holder.mpLineChart.legend
        legend.isEnabled = false

        val ll1 = LimitLine(22f, "Batas Aman Bawah")
        ll1.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
        ll1.textSize = 10f
        ll1.lineWidth = 3f
        ll1.lineColor = Color.parseColor("#DDA533")

        val ll2 = LimitLine(27f, "Batas Aman Atas")
        ll2.labelPosition = LimitLine.LimitLabelPosition.RIGHT_TOP
        ll2.textSize = 10f
        ll2.lineWidth = 3f
        ll2.lineColor = Color.parseColor("#B21B36")

        val xAxis: XAxis = holder.mpLineChart.xAxis
        xAxis.setAvoidFirstLastClipping(true)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.setDrawGridLines(true)
        xAxis.setDrawAxisLine(false)
        xAxis.axisMinimum = 0f
        xAxis.axisMaximum  = 44f

        var yAxis: YAxis = holder.mpLineChart.axisLeft
        yAxis.setDrawGridLines(true)
        yAxis.isEnabled = true
        yAxis.removeAllLimitLines()
        yAxis.axisMaximum = 28f
        yAxis.axisMinimum = 21f
        yAxis.resetAxisMaximum()
        yAxis.setDrawAxisLine(false)

        yAxis.setDrawLimitLinesBehindData(true)
        xAxis.setDrawLimitLinesBehindData(true)
        yAxis.addLimitLine(ll1)
        yAxis.addLimitLine(ll2)

        holder.mpLineChart.axisRight.isEnabled = false
        holder.mpLineChart.isAutoScaleMinMaxEnabled = true
        holder.mpLineChart.notifyDataSetChanged()
        holder.mpLineChart.invalidate()
    }
}