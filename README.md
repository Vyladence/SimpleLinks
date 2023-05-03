# SimpleLinks

SimpleLinks is, as the name implies, a simple plugin to add links to your server. It adds two commands; one to view the links and one to reload the plugin.

# Commands & Permissions

SimpleLinks, being *simple*, adds minimal commands to your server.

`/links` (`simplelinks.use`) - Displays links as configured <br/>
`/simplelinks` (`simplelinks.admin`) - Displays plugin information <br/>
`/simplelinks reload` (`simplelinks.admin`) - Reloads the plugin's config

# Configuration

Configuration is easy. Once you start your server with the plugin installed, a config.yml file will be written, as is the case with any plugin.

Opening the file shows a very simple structure. The lines you want to show when a user runs the `/links` command will go under the `lines:` key. You can add a theoretically infinite number of lines here but I personally wouldn't go above 15 or so.

SimpleLinks supports YAML color and formatting codes using the `&` prefix and HEX codes using the `#` or `&#` prefix.

At this time, SimpleLinks does not support gradients natively, however it is possible to have them using an online gradient generator such as [this](https://minecraft.menu/minecraft-rgb-generator).

Once you have made your changes to the config, run `/simplelinks reload` to reload it.

If your config file breaks for whatever reason, you can just delete it and run `/simplelinks reload` to create a fresh one.

<details>
<summary>Example Configurations</summary>

  #### Example 1
  ```
  lines:
    - '&8&m-------------------&8[ &#520dfb&lS&#630cfa&li&#750af8&lm&#8609f7&lp&#9708f5&ll&#a907f4&le&#ba05f3&lL&#cb04f1&li&#dc03f0&ln&#ee01ee&lk&#ff00ed&ls &8]&8&m-------------------'
    - '&eWebsite: &b&nhttps://example.net'
    - '&aDynmap: &b&nhttps://example.net/map'
    - '&9Discord: &b&nhttps://discord.gg/eXaMpLE'
    - '&8&m----------------------------------------------------'
  ```
  <img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Example_1.png">
  
  #### Example 2
  ```
  lines:
    - "This is a plain message"
    - "&aThis message uses a single color with YAML color codes"
    - "&aThis message uses &bmultiple colors with YAML color codes"
    - "#3791fbThis one uses a single color with HEX codes"
    - "#4ee27bThis one uses #fb3454multiple colors with HEX codes"
    - "#fbed75This message uses HEX color and then &9YAML color"
    - "&eThis message uses YAML color and then #4ee27bHEX color"
    - "&lThis message shows plain text YAML formatting"
    - "&6&nThis message uses YAML coloring & formatting"
    - "#da1b89&mThis message uses HEX coloring and YAML formatting"
  ```
<img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Example_2.png">

#### Example 3
  ```
  lines:
    - "&#8500fbH&#8e00f2e&#9600ear&#9f00e1e &#a800d8i&#b100d0s &#b900c7a &#c200bfg&#cb00b6r&#d300ada&#dc00a5d&#e5009ci&#ee0093e&#f6008bn&#ff0082t"
  ```
<img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Example_3.png">
</details>

# Editing Code & Building from Source

SimpleLinks uses Gradle so if you know what you're doing, ignore this section.

To build from source, you need an IDE. For this I'll be using [IntelliJ Idea](https://www.jetbrains.com/idea/download/) but I figure the steps will be similar for [Eclipse](https://www.eclipse.org/downloads/).

First, of course [download the repo as a zip file](https://github.com/Vyladence/SimpleLinks/archive/refs/heads/main.zip). Click the hyperlink or click the green "Code" button above, then click *Download ZIP*. Then, place it in whichever directory is most convenient and extract it. Open the resulting folder (containing "src" at its root) in your IDE. You can usually do this by right-clicking the folder, then clicking something along the lines of "open as project".

Once in your IDE, steps will differ. As I said, I'll be using IntelliJ Idea to demonstrate. I will also be using the new UI, so if you're still using the old one and don't know how to do the following steps, switch to the new UI using the button shown below

<img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Enable_Modern_UI.png">

Once you have the project opened, IntelliJ will start configuring.. something. Take this time to select your JDK and set up Gradle.

Let's start with the JDK. First, go to the cog in the top right, then click *Project Structure*

<img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Open_Project_Structure.png">

Once in here, select your preferred SDK in the drop-down. As of writing this (May 2nd, 2023) the one automatically installed is Eclipse Temurin 17.

<img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Select_SDK.png">

Then hit the blue *OK* button in the bottom right.

After that, we need to configure Gradle. This is just as easy. First, open the *Run Configuration* menu by clicking *Current File* in the top-right, then click *Edit Configurations*.

<img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Edit_Configuration.png">

In the window that appears, click on the plus sign towards the top-left, then select *Gradle*.

<img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Configure_Gradle.png">

After that, all that's left is to add the *build* task. To do this, select the box that says *Tasks and Arguments* and then select *build*.

<img src="https://raw.githubusercontent.com/Vyladence/Resources/main/SimpleLinks_Gradle_Build.png">

Then click *OK*.

And you're done! Now you can edit the code in your IDE, and to build the plugin all you need to do is click the green play button in the top right. This will output the .jar file to `~project/build/libs/`. From there, just drop the plugin in your server's plugin folder and start it up!
