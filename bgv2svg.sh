#!/bin/bash

# Check if a directory argument is passed
if [ -z "$1" ]; then
    echo "Usage: $0 <directory> <flag> <flag>..."
    exit 1
fi

# Input directory
INPUT_DIR=$1

# Check if the input is a valid directory
if [[ $INPUT_DIR == "-help" ]]; then
    echo "Following flags can be passed: "
    echo ""
    echo "--full-truffle-args    shows full Truffle argument nodes, which are simplified by default"
    echo "--show-frame-state     shows frame state nodes, which are hidden by default"
    echo "--no-simplify-alloc    turns off the pass to create synthetic allocation nodes"
    echo "--show-reachability-fences turns off the pass to hide reachability fences"
    echo "--show-null-fields     shows null fields to allocations, which are hidden by default"
    echo "--show-pi              shows pi nodes, which are hidden by default"
    echo "--show-begin-end       shows begin and end nodes, which are hidden by default"
    echo "--hide-floating        hides nodes that aren't fixed by control flow"
    echo "--no-reduce-edges      turns off the pass to reduce the number of edges by inlining simple nodes above their users"
    echo "--no-simplify          turns off passes that simplify the graph, except frame states are still hidden"
    echo "--draw-blocks          to draw basic block information if available"

    exit 0
elif [ ! -d "$INPUT_DIR" ]; then
    echo "Error: Directory '$INPUT_DIR' does not exist."
    exit 1
fi
shift
cd $INPUT_DIR
# Iterate through each .bgv file in the input directory
for bgv_file in *.bgv; do
    # Skip if no .bgv files found
    [ -e "$bgv_file" ] || { echo "No .bgv files found in the directory."; exit 1; }

    # Get the list of graphs and directories using seafoam <file.bgv> list
    seafoam_output=$(seafoam "$bgv_file" list)

    # Iterate over each line of the seafoam output
    while IFS= read -r line; do
        # Extract graph index and graph path from the output
        graph_index=$(echo "$line" | cut -d':' -f2 | awk '{print $1}')
        graph_path=$(echo "$line" | cut -d' ' -f2-)
        graph_dir=$(dirname "$graph_path")
        graph_name=$(basename "$graph_path")

        # Create directory structure for the graph path
        mkdir -p "$graph_dir"

        # Render the .svg file using seafoam
        output_svg="$graph_dir/$graph_index $graph_name.svg"
        `seafoam "$bgv_file:$graph_index" render --out "$output_svg" $@`

        echo "Rendered $output_svg"

    done <<< "$seafoam_output"

done

echo "SVG generation completed."