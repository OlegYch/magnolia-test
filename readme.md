Demo for https://github.com/scala/scala3/issues/19924


`sbt clean;+compile;clean;+compile;clean;+compile;clean;+compile;clean;+compile;clean;+compile;clean;+compile;clean;+compile;clean;+compile;clean;+compile;`

After some warmup 3.3.3 version will compile in 3s, and 3.4.0 in 7s (on my laptop ©).