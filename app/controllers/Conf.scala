package controllers

import javax.inject.{Inject, Provider}

import play.api.Configuration
import com.newrelic.api.agent.NewRelic



class Conf(configuration: Configuration) {
  def clusterHostname = configuration.getString("akka.remote.netty.tcp.hostname").getOrElse("127.0.0.1")

  def clusterPort = configuration.getInt("akka.remote.netty.tcp.port").getOrElse(0)
}

class ConfProvider @Inject() (configuration: Configuration) extends Provider[Conf] {

  lazy val get = new Conf(configuration)

}
