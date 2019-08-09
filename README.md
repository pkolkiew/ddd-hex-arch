# ddd-hex-arch
playground for ddd, hexagonal arch, cqrs etc.

## TODO

* CQRS
* DDD stuff 
* SPOCK + GROOVY unit tests
* int tests 


pom example:
<properties>
  ...
  <docker.image.prefix>
  <docker.repository>
  <dockerTag>${git.commit.id.abbrev}</dockerTag>
</properties>
    
    <build>
        <plugins>

            <plugin>
                <groupId>pl.project13.maven</groupId>
                <artifactId>git-commit-id-plugin</artifactId>
                <!--<version>3.0.0</version>-->
                <version>2.2.6</version>
                <executions>
                    <execution>
                        <id>get-the-git-infos</id>
                        <goals>
                            <goal>revision</goal>
                        </goals>
                        <phase>initialize</phase>
                    </execution>
                    <execution>
                        <id>validate-the-git-infos</id>
                        <goals>
                            <goal>validateRevision</goal>
                        </goals>
                        <phase>package</phase>
                    </execution>
                </executions>

                <configuration>
                    <failOnNoGitDirectory>true</failOnNoGitDirectory>
                    <verbose>true</verbose>
                    <dotGitDirectory>${project.basedir}/../.git</dotGitDirectory>
                    <dateFormatTimeZone>${user.timezone}</dateFormatTimeZone>
                    <generateGitPropertiesFile>true</generateGitPropertiesFile>
                    <generateGitPropertiesFilename>${project.build.outputDirectory}/git.properties</generateGitPropertiesFilename>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                            <goal>build-info</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <profiles>
        <profile>
            <id>docker-image-build</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>com.spotify</groupId>
                        <artifactId>dockerfile-maven</artifactId>
                        <version>1.2.2</version>
                        <executions>
                            <execution>
                                <id>default</id>
                                <goals>
                                    <goal>build</goal>
                                    <goal>tag</goal>
                                    <goal>push</goal>
                                </goals>
                            </execution>
                        </executions>
                        <configuration>
                            <repository>${docker.repository}/${docker.image.prefix}/${project.artifactId}</repository>
                            <useMavenSettingsForAuth>true</useMavenSettingsForAuth>
                            <googleContainerRegistryEnabled>false</googleContainerRegistryEnabled>
                            <tag>${project.version}-${dockerTag}</tag>
                            <buildArgs>
                                <JAR_FILE>${project.build.finalName}.jar</JAR_FILE>
                                <HTTP_PROXY>http://</HTTP_PROXY>
                            </buildArgs>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
        </profile>
        <profile>
            <id>gitlab-ci</id>
            <activation>
                <property>
                    <name>env.CI</name>
                </property>
            </activation>
            <properties>
                <!--suppress UnresolvedMavenProperty -->
                <dockerTag>${env.CI_JOB_ID}</dockerTag>
            </properties>
        </profile>
    </profiles>
