package DesignPattern.DelegatePattern

interface Downloader {
    fun download(): String
    fun stop(): String
}

open class ImageDownloader : Downloader {
    override fun download(): String {
        return "ImageDownLoad Start"
    }

    override fun stop(): String {
        return "ImageDownLoad Stopped"
    }
}

class DownloadProgram(downloader: Downloader) : Downloader by downloader

//class DownloadProgram(downloader: Downloader) : Downloader {
//    private val _downloader: Downloader = downloader
//
//    override fun download(): String {
//        return _downloader.download()
//    }
//
//    override fun stop(): String {
//        return _downloader.stop()
//    }
//}

