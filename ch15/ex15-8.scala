def exists[I](f: I => Boolean): Process[I,Boolean] =
  lift(f) |> any

def any: Procsss[Boolean,Boolean] =
  loop(false)((b:Boolean,s)  (s || b, s || b))

def existsResult[I](f: I => Boolean) =
  exists(f) |> takeThrough(!_) |> dropWhile(!_) |> echo.orElse(emit(false))

def takeThrough[I](f: I => Boolean): Process[I,I] =
  takeWhile(f) ++ echo

def echo[I]: Process[I,I] = await(i => emit(i))
