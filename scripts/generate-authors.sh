#!/usr/bin/env bash

# Based on generate-authors.sh script of Moby
# https://github.com/moby/moby/blob/master/hack/generate-authors.sh

authorsFile=AUTHORS.md

set -e

cd "$(dirname "$(readlink -f "$BASH_SOURCE")")/.."

{
	cat <<-'EOH'
	# This is the list of JYugiohDb authors for copyright purposes.
	
	# This file lists all individuals having contributed content to the repository.
	# For how it is generated, see `script/generate-authors.sh`.
	EOH
	echo
	git log --format='%aN <%aE>' | LC_ALL=C.UTF-8 sort -uf
	
} > $authorsFile && sed -i '$d' $authorsFile
