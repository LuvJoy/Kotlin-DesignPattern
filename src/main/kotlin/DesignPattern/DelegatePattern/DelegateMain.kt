package DesignPattern.DelegatePattern

fun main() {
    val imageDownloader = ImageDownloader()
    val program = DownloadProgram(imageDownloader)
    println(program.download())
    println(program.stop())
}