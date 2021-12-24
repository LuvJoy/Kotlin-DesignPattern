package KotlinPlayground.runcatching

import java.net.http.HttpTimeoutException

fun main() {
    runCatchingGetOrDefault()
}

private fun existingExceptionHandling() {
    try {
        val result = fetchData()
        showResult(result)
    } catch (e: Exception) {
        handleException(exception = e)
    } finally {
        println("Finish!")
    }
}

private fun runCatchingExceptionHandling() {
    runCatching {
        fetchData()
    }.mapCatching {
        it + 1
        throw RuntimeException("wrongwrongwrong")  // 1. mapCatching 블럭에서 에러 발생
    }.onSuccess { result ->
        showResult(result)
    }.onFailure { exception ->
        handleException(exception)                 // 2.  mapCatching 에러 발생시 실행된다
    }
}

private fun runCatchingWithRecoverSuccess() {
        runCatching {
            fetchData()                                // 0. 가져오고자 하는 데이터는 [200]이다
            throw RuntimeException("wrongwrongwrong")  // 1, runCatching 블럭에서 에러 발생
        }.recover { exception ->
            204
        }.onSuccess { result ->
            showResult(result)                         // 2.1 recover에서 실패 시 실행되지 않음
        }.onFailure { exception ->
            handleException(exception)                 // 2.1 recover에서 실패 시 실행되지 않음
        }
}

private fun runCatchingWithRecoverFailed() {
    try {
        runCatching {
            fetchData()                                // 0. 가져오고자 하는 데이터는 [200]이다
            throw RuntimeException("wrongwrongwrong")  // 1, runCatching 블럭에서 에러 발생
        }.recover { exception ->
            throw RuntimeException("recover failed")   // 2. 에러 발생 후 recover 블럭실행, 하지만 또 에러발생
            204
        }.onSuccess { result ->
            showResult(result)                         // 2.1 recover 에서 에러 발생시 실행되지 않음
        }.onFailure { exception ->
            handleException(exception)                 // 2.1 recover 에서 에러 발생시 실행되지 않음
        }
    } catch (e: Throwable) {
        println("[외부 catch] : ${e.message}")          // 3. recover에서 발생한 에러가 외부로 나와서 바깥의 catch 블럭에 잡힘
    }
}

private fun runCatchingWithRecoverCatchingFailed() {
    try {
        runCatching {
            fetchData()                                // 0. 가져오고자 하는 데이터는 [200]이다
            throw RuntimeException("wrongwrongwrong")  // 1, runCatching 블럭에서 에러 발생
        }.recoverCatching { exception ->
            throw RuntimeException("recover failed")   // 2. 에러 발생 후 recover 블럭실행, 하지만 또 에러발생
            204
        }.onSuccess { result ->
            showResult(result)
        }.onFailure { exception ->
            handleException(exception)                 // 3. recoverCatching 에서 에러 발생시 실행된다
        }
    } catch (e: Throwable) {
        println("[외부 catch] : ${e.message}")          // recoverCatching은 내부에서 에러를 처리하기 때문에 외부의 catch 블럭은 실행 X
    }
}

private fun runCatchingFold() {
    runCatching {
        fetchData()                                // 0. 가져오고자 하는 데이터는 [200]이다
    }.fold(
        onSuccess = { result ->
            println(result)
        },
        onFailure = { throwable ->
            println(throwable.message)
        }
    )
}

private fun runCatchingGetOrDefault() {
    val result = runCatching {
        fetchData()
        throw RuntimeException("서버가 기분이 좋지 않습니다")
    }.onSuccess { data ->
        data
    }.onFailure { exception ->
        println("exception 발생")
    }.getOrDefault(100)

    println(result)
}

private fun fetchData(): Int {
    return 200
}

private fun fetchDataWithException(): Int {
    throw HttpTimeoutException("Network TimeOut Exception")
    return 200
}

private fun handleException(exception: Throwable) {
    println("[onFailure] : ${exception.message}")
}

private fun showResult(result: Int) {
    println("Result : $result")
}