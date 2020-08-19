# Identify the running shell.  If it's not a standard shell
# exit now.
# Depending on the shell, there are different ways to access
# the name of the current script.
case $SHELL in
  */bin/bash)
    THIS_FILE="${BASH_SOURCE[0]}"
    ;;
  */bin/zsh)
    THIS_FILE="${(%):-%N}"
    ;;
  *)
    echo "Warning: $SHELL is not a supported shell (bash and zsh is supported)"
    exit 1
esac

# Add the bin directory in the repo to the path
export SYSTEMLOGIC_PATH="$(dirname ${THIS_FILE})"
export PATH="$(cd ${SYSTEMLOGIC_PATH}; pwd -P)/bin:${PATH}"
