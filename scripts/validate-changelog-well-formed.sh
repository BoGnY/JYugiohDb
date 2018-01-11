#!/usr/bin/env bash

# Based on validate/changelog-well-formed.sh script of Moby
# https://github.com/moby/moby/blob/master/hack/validate/changelog-well-formed.sh

changelogFile=${1:-CHANGELOG.md}

if [ ! -r "$changelogFile" ]; then
  echo "Unable to read file $changelogFile" >&2
  exit 1
fi

changelogWellFormed=1

# e.g. "## 1.12.3 (2016-10-26)"
VER_LINE_REGEX='^## [0-9]+\.[0-9]+\.[0-9]+(-ce)? \([0-9]+-[0-9]+-[0-9]+\)$'
while read -r line; do
  if ! [[ "$line" =~ $VER_LINE_REGEX ]]; then
    echo "Malformed changelog $changelogFile line \"$line\"" >&2
    changelogWellFormed=0
  fi
done < <(grep '^## ' $changelogFile)

if [[ "$changelogWellFormed" == "1" ]]; then
  echo "Congratulations! Changelog $changelogFile is well-formed."
else
  exit 2
fi
