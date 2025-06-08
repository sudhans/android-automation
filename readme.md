# Docker Command to start emulator
````sh
sudo docker run --rm -it \
  --privileged \
  --device /dev/kvm \
  --mount type=tmpfs,destination=/data \
  -e ADBKEY="$(cat ~/.android/adbkey)" \
  -p 8554:8554/tcp \
  -p 5555:5555/tcp \
  us-docker.pkg.dev/android-emulator-268719/images/30-google-x64:30.1.2
````

This will pull down the container if it is not locally available and launch it. You can see that is
starting:

After this you can connect to the device by configuring adb:

```sh
  adb connect localhost:5555
```

The device should now show up after a while as:

```sh
$ adb devices

List of devices attached
localhost:5555 device
```

For GUI, you could install scrcpy

````shell
sudo apt install -y scrcpy

````

To run instrumented tests,
````sh
./gradlew app:connectedCheck
````