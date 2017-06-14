Glob API for Scala.js
================================
This is a Scala.js type-safe binding for [glob](https://www.npmjs.com/package/glob)

A little globber.

#### Build Dependencies

* [SBT v0.13.13](http://www.scala-sbt.org/download.html)

#### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

#### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

#### Examples

##### Using `Glob` asynchronously via callbacks:

```scala
import io.scalajs.JSON
import io.scalajs.npm.glob._

Glob("**/*.scala", (err, files) => {
  println(s"files: ${JSON.stringify(files)}")
})
```

##### Using `Glob` asynchronously via promises:

```scala
import io.scalajs.JSON
import io.scalajs.npm.glob._
import scalajs.concurrent.JSExecutionContext.Implicits.queue

Glob.future("**/*.scala") foreach { files =>
  println(s"files: ${JSON.stringify(files)}")
}
```

##### Using `Glob` synchronously:

```scala
import io.scalajs.JSON
import io.scalajs.npm.glob._

val files = Glob.sync("**/*.scala", new GlobOptions())
println(s"files: ${JSON.stringify(files)}")
```

##### Using `Glob` as an instance:

```scala
import io.scalajs.JSON
import io.scalajs.npm.glob._

new Glob("**/*.scala", (err, files) => {
    println(s"files: ${JSON.stringify(files)}")
})
```

##### The output from all of the examples is identical:

```text
files: ["src/main/scala/io/scalajs/npm/glob/Glob.scala","src/main/scala/io/scalajs/npm/glob/GlobOptions.scala",
"src/main/scala/io/scalajs/npm/glob/package.scala","src/test/scala/io/scalajs/npm/glob/GlobTest.scala"]
```

#### Artifacts and Resolvers

To add the `Glob` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "glob" % "0.4.0"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```