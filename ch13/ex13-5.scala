import java.nio._
import java.nio.channels._

def read(file: AsynchronousFileChannel,
         fromPosition: Long,
         numBytes: Int): Par[Either[Throwable, Array[Byte]]] =
  Par.async { (cb: Either[Throwable, Array[Byte]] => Unit) =>
    val buf = ByteBuffer.allocate(numBytes)
    file.read(buf, fromPosition, (), new CompletionHandler[Integer, Unit] {
      def completed(bytesRead: Integer, ignore: Unit) = {
        var arr = new Array[Byte](bytesRead)
        buf.slice.get(arr, 0, bytesRead)
        cb(Right(arr))
      }
      def failed(err: Throwable, ignore: Unit) =
        cb(Left(err))
    })
  }

// note: We can wrap `read` in `Free[Par,A]` using the `Suspend` 
