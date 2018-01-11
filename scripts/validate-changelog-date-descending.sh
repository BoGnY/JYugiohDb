#!/usr/bin/env bash

# Based on validate/changelog-date-descending.sh script of Moby
# https://github.com/moby/moby/blob/master/hack/validate/changelog-date-descending.sh

changelogFile=${1:-CHANGELOG.md}

if [ ! -r "$changelogFile" ]; then
  echo "Unable to read file $changelogFile" >&2
  exit 1
fi

grep -e '^## ' "$changelogFile" | awk '{print$3}' | sort -c -r || exit 2

echo "Congratulations! Changelog $changelogFile dates are in descending order."
