# Thunder

[![](https://jitpack.io/v/qiugang/Thunder.svg)](https://jitpack.io/#qiugang/Thunder)

Android OkHttp util package let response callback at MainThread(UIThread), also it‘s lifecycle safety.

⚠️ Thunder‘s code is based on [SugarTask](https://github.com/mthli/SugarTask)(Very nice code👍)

Support Android API 14 and UP.

## Gradle

At your root `build.gradle` file:

```groovy
repositories {
    // ...
    maven { url 'https://jitpack.io' }
}
```

And then at your application `build.gradle` file:

```groovy
dependencies {
    compile 'com.github.qiugang:Thunder:v0.1'
}
```

## Usage

At your MainThread(UIThread), start OkHttp request just like this:

```java
Thunder.with(this)
    .assign(new CallBuilder().url("https://raw.github.com/square/okhttp/master/README.md")
                            .buildGet())
    .finish(new Thunder.ResponseCallBack() {
        @Override
        public void onResponse(ResponseData response) {
            // handle response here
        }
    })
    .broken(new Thunder.FailureCallBack() {
        @Override
        public void onFailure(Exception e) {
        // handle exception here
        }
    })
    .execute();
```

## Thanks

 - [SugarTask](https://github.com/mthli/SugarTask)

## License
    
    Copyright 2016 Origin Qiu
    Copyright 2015 Matthew Lee

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

