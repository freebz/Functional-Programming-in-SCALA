val forkProp = Prop.forAllPar(pint2)(i => equal(Par.fork(i), i)) tag "fork"
