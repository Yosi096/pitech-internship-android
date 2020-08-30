package pitech.tasklinechart

import io.reactivex.Observable

interface ApiLine {
    fun getLine() : Observable<LineResponse>
}