# spring-boot-docker-spotify
Packaging a Spring Boot Application with the Docker Maven Plugin by Spotify.

This repository is accompanied by a blog post on http://www.marcolenzo.eu/2016/04/10/package-a-spring-boot-application-into-a-docker-container/

To build the docker image and push it to registry: `mvn clean package -DpushImage`

To simply build the docker image: `mvn clean package`

Note you need to modify the name of the image in the plugin configuration section:

```xml
<plugin>
	<groupId>com.spotify</groupId>
	<artifactId>docker-maven-plugin</artifactId>
	<version>0.4.5</version>
	<executions>
		<execution>
			<id>build-image</id>
			<phase>package</phase>
			<goals>
				<goal>build</goal>
			</goals>
			<configuration>
				<imageName>192.168.0.19:5000/checkip:${project.version}</imageName>
				<dockerDirectory>${basedir}/src/main/docker</dockerDirectory>
				<resources>
					<resource>
  					<targetPath>/</targetPath>
	  				<directory>${project.build.directory}</directory>
		  			<include>${project.build.finalName}.jar</include>
			  	</resource>
			  </resources>
		  </configuration>
	  </execution>
	</executions>
</plugin>
```
