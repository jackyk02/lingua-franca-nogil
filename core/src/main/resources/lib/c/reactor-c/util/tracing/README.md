## util/tracing

This directory contains the source code for utilities that are standalone executables
for post-processing tracing data created by the tracing function in Lingua Franca.

Utilities for visualizing the data are contained in the [visualization](visualization/README.md)
directory.

* trace\_to\_csv: Creates a comma-separated values text file from a binary trace file.
  The resulting file is suitable for analyzing in spreadsheet programs such as Excel.

* trace\_to\_chrome: Creates a JSON file suitable for importing into Chrome's trace
  visualizer. Point Chrome to chrome://tracing/ and load the resulting file.

* trace\_to\_influxdb: A preliminary implementation that takes a binary trace file
  and uploads its data into [InfluxDB](https://en.wikipedia.org/wiki/InfluxDB).

* fedsd: A utility that converts trace files from a federate into sequence diagrams
  showing the interactions between federates and the RTI.

## Installing

```
    sudo make install
```
Will install the tracing executables to the `bin` directory under `/usr/local/`. To install them to a different location, use the `INSTALL_PREFIX` flag, e.g.

```
  make install INSTALL_PREFIX=~/.local/
```
which will install the executables under `~/.local/bin/`.
